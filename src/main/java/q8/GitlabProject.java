package q8;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class GitlabProject implements GitlabPermissionsNode {
    String name;
    private Map<User, PermissionsLevel> members = new HashMap<>();

    public GitlabProject(String name, User creator) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public PermissionsLevel getUserPermissions(User u) {
        return members.get(u);
    }

    @Override
    public void updateUserPermissions(User userToUpdate, PermissionsLevel permissions, User userUpdating)
            throws GitlabAuthorisationException {
        authorise(userUpdating, permissions);
        members.put(userToUpdate, permissions);
    }

    @Override
    public GitlabGroup createSubgroup(String name, User creator) throws GitlabAuthorisationException {
        return null;
    }

    @Override
    public GitlabProject createProject(String name, User creator) throws GitlabAuthorisationException {
        return null;
    }

    public void runPipeline(Runnable runnable) {
        GitlabRunner runner = GitlabRunner.createNewRunner();
        runner.run(runnable);
    }

    private void authorise(User u, PermissionsLevel requiredPermissionsLevel) throws GitlabAuthorisationException {
        int perms = getUserPermissions(u).ordinal();
        int requiredPerms = requiredPermissionsLevel.ordinal();
        if (perms > requiredPerms) {
            throw new GitlabAuthorisationException("User is unauthorised!");
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("type", "project");
        json.put("name", name);
        return json;
    }
}
