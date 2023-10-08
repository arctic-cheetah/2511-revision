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
                // Is the node a booleanExpression or BooleanOperator?
                if (obj.get(currKey).toString().equals("value")) {
                    currKey = keys.next();
                    String boolValue = obj.get(currKey).toString();
                    return new BooleanVariable(boolValue);
                } else {
                    node = new BooleanOperator(obj.get(currKey).toString());
                }
                // Node is an boolean Operator
            } else if (currKey.equals("subnode1")) {
                JSONObject tmp = (JSONObject) obj.get(currKey);
                node.setLeft(getBooleanNode(tmp));
            } else if (currKey.equals("subnode2")) {
                JSONObject tmp = (JSONObject) obj.get(currKey);
                node.setRight((getBooleanNode(tmp)));
            }

        }
        // If we have a `not` operator, set the right node to be the left to prevent errors
        if (node.getRight() == null)
            node.setRight(node.getLeft());
        return node;
    }
}
