package q8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GitlabFactory {
    public static String loadResourceFile(String path) throws IOException {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return new String(GitlabFactory.class.getResourceAsStream(path).readAllBytes());
    }

    public static GitlabPermissionsNode gitlabFromJson(String jsonString, User owner) {
        JSONObject j = new JSONObject(jsonString);
        GitlabPermissionsNode n = null;
        try {
            n = gitlabFromJsonHelper(j, owner, n);
        } catch (Exception e) {
            System.out.println(jsonString);
        }
        return n;
    }

    public static GitlabPermissionsNode gitlabFromJsonHelper(JSONObject j, User owner, GitlabPermissionsNode root)
            throws GitlabAuthorisationException {
        // Check the iterator keys order
        Iterator<String> keys = getSortedKeys(j);
        GitlabPermissionsNode n = null;
        String currName = "";
        while (keys.hasNext()) {
            String key = keys.next();
            // Check each key
            if (key.equals("type")) {
                String val = j.get(key).toString();
                if (val.equals("group")) {
                    if (root == null) {
                        n = new GitlabGroup(currName, owner);
                    } else {
                        n = root.createSubgroup(currName, owner);
                    }
                } else if (val.equals("project")) {
                    root.createProject(currName, owner);
                }

            }
            if (key.equals("name")) {
                currName = j.get(key).toString();
            }
            if (key.equals("subgroups")) {
                // Iterate through each sub group!
                JSONArray subgroup = j.getJSONArray(key);

                for (Object object : subgroup) {
                    gitlabFromJsonHelper((JSONObject) object, owner, n);
                }
            }
        }
        return n;
    }

    private static Iterator<String> getSortedKeys(JSONObject j) {
        Iterator<String> tmp = j.keys();
        List<String> keys = new ArrayList<>();
        tmp.forEachRemaining(keys::add);
        // Reverse the keys so name goes first
        // Then type
        Collections.reverse(keys);
        String s1 = keys.get(0);
        keys.remove(0);
        keys.add(1, s1);
        return keys.iterator();
    }
}
