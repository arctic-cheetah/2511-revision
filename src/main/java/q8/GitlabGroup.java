package q8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class GitlabGroup implements GitlabPermissionsNode {
    String name;
    private Map<User, PermissionsLevel> members = new HashMap<>();
    private List<GitlabPermissionsNode> subgroups = new ArrayList<>();

    public GitlabGroup(String name, User creator) {
        this.name = name;
        members.put(creator, PermissionsLevel.OWNER);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getUsersOfPermissionLevel(PermissionsLevel level) {
        Set<User> membersSet = members.keySet();
        List<String> names = new ArrayList<>();
        names = membersSet.stream().filter(e -> members.get(e).equals(level)).map(e -> e.getName())
                .collect(Collectors.toList());
        return names;
    }

    @Override
    public PermissionsLevel getUserPermissions(User u) {
        return members.get(u);
    }

    @Override
    public void updateUserPermissions(User userToUpdate, PermissionsLevel permissions, User userUpdating)
            throws GitlabAuthorisationException {
        authorise(userUpdating, PermissionsLevel.OWNER);
        alreadyHasPermissions(userToUpdate, permissions);

        for (GitlabPermissionsNode subgroups : subgroups) {
            subgroups.updateUserPermissions(userToUpdate, permissions, userUpdating);
        }
        // Add
        members.put(userToUpdate, permissions);
    }

    private void alreadyHasPermissions(User userToUpdate, PermissionsLevel permissions)
            throws GitlabAuthorisationException {
        PermissionsLevel currPerm = getUserPermissions(userToUpdate);
        if (currPerm != null) {
            // Similarly, if a user tries to give permissions to another user in a group which
            //by filtering authorisation they already have permissions on, a GitlabAuthorisationException should be thrown.
            if (currPerm.ordinal() < permissions.ordinal()) {
                throw new GitlabAuthorisationException("User is already has permissions!");
            }
        }
    }

    @Override
    public GitlabGroup createSubgroup(String name, User creator) throws GitlabAuthorisationException {
        authorise(creator, PermissionsLevel.MAINTAINER);
        GitlabGroup g = new GitlabGroup(name, creator);
        subgroups.add(g);
        return g;
    }

    @Override
    public GitlabProject createProject(String name, User creator) throws GitlabAuthorisationException {
        authorise(creator, PermissionsLevel.MAINTAINER);
        GitlabProject p = new GitlabProject(name, creator);
        subgroups.add(p);
        return p;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("type", "group");
        json.put("name", name);

        JSONArray subgroupJSON = new JSONArray(
                subgroups.stream().map(GitlabPermissionsNode::toJSON).collect(Collectors.toList()));
        json.put("subgroups", subgroupJSON);
        return json;
    }

    private void authorise(User u, PermissionsLevel requiredPermissionsLevel) throws GitlabAuthorisationException {
        int perms = getUserPermissions(u).ordinal();
        int requiredPerms = requiredPermissionsLevel.ordinal();
        if (perms > requiredPerms) {
            throw new GitlabAuthorisationException("User is unauthorised!");
        }
    }
}
