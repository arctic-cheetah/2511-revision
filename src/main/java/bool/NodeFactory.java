package bool;

import java.util.Iterator;
import org.json.JSONObject;

public class NodeFactory {
    public static BooleanNode getBooleanNode(JSONObject obj) {
        BooleanOperator node = new BooleanOperator();
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String currKey = keys.next();

            if (currKey.equals("node")) {
                // Is the node a booleanVariable or BooleanOperator?
                if (obj.get(currKey).toString().equals("value")) {
                    // node is a booleanVariable
                    currKey = keys.next();
                    return new BooleanVariable(obj.get(currKey).toString());
                } else {
                    // Node is an boolean Operator, check the others
                    node = BooleanOperator.createBooleanOperator(obj.get(currKey).toString());
                }
                // Recursion below
            } else if (currKey.equals("subnode1")) {
                node.setLeft(getBooleanNode(getJsonObjFromKey(obj, currKey)));
            } else if (currKey.equals("subnode2")) {
                node.setRight(getBooleanNode(getJsonObjFromKey(obj, currKey)));
            }

        }
        // If we have a `not` operator, set the right node to be the left to prevent errors
        if (node.getRight() == null)
            node.setRight(node.getLeft());
        return node;
    }

    private static JSONObject getJsonObjFromKey(JSONObject obj, String currKey) {
        return (JSONObject) obj.get(currKey);
    }
}
