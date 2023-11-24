package businessRule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import businessRule.businessNode.BusinessNode;
import businessRule.businessNode.operator.AndOperator;
import businessRule.businessNode.operator.GreaterThanOperator;
import businessRule.businessNode.operator.NotBlankOperator;
import businessRule.businessNode.operator.OperatorNode;
import businessRule.businessNode.operator.OrOperator;
import businessRule.businessNode.value.ConstantNode;
import businessRule.businessNode.value.LookUpNode;

public class BusinessFactory {
    public static String loadResourceFile(String path) throws IOException {
        InputStream s = BusinessFactory.class.getResourceAsStream(path);
        return new String(s.readAllBytes());
    }

    /**
     * @pre assume that root node is an operator node
     * @param data
     * @return
     */

    public static BusinessNode businessNodeFromJson(String data) {
        JSONObject j = new JSONObject(data);
        BusinessNode n = nodeCreatorHelper(j, null);
        return n;
    }

    public static BusinessNode nodeCreatorHelper(JSONObject json, BusinessNode root) {
        // Sort the keys in case: CHECK!
        // NOT NEEDED
        Iterator<String> k = json.keys();
        BusinessNode n = null;

        // List<String> keys = new ArrayList<>();
        // k.forEachRemaining(keys::add);
        while (k.hasNext()) {
            String currKey = k.next();
            String val = json.get(currKey).toString();

            if (currKey.equals("Operator")) {

                if (root == null) {
                    n = operatorRootNodeCreator(val);
                } else {
                    // TODO

                    if (val.equalsIgnoreCase("AND")) {
                        n = new AndOperator("AND");
                    } else if (val.equalsIgnoreCase("OR")) {
                        n = new OrOperator("OR");
                    } else if (val.equalsIgnoreCase("NOT BLANK")) {
                        n = new NotBlankOperator("NOT BLANK");
                    } else if (val.equalsIgnoreCase("GREATER THAN")) {
                        n = new GreaterThanOperator("GREATER THAN");
                    } else if (val.equalsIgnoreCase("LOOKUP")) {
                        currKey = k.next();
                        return new LookUpNode(json.get(currKey).toString());
                    } else if (val.equalsIgnoreCase("CONSTANT")) {
                        currKey = k.next();
                        return new ConstantNode(Double.parseDouble(json.get(currKey).toString()));
                    }

                }
            }
            // Recurse here!
            if (currKey.equals("Args")) {
                JSONArray arr = json.getJSONArray(currKey);
                OperatorNode operator = (OperatorNode) n;
                List<BusinessNode> args = new ArrayList<>();
                for (Object o : arr) {
                    args.add(nodeCreatorHelper((JSONObject) o, n));
                }
                operator.setArgs(args);
            }
            if (currKey.equals("Arg")) {
                OperatorNode operator = (OperatorNode) n;
                List<BusinessNode> args = new ArrayList<>();

                JSONObject o = json.getJSONObject(currKey);
                args.add(nodeCreatorHelper((JSONObject) o, n));
                operator.setArgs(args);
            }
        }

        return n;

    }

    private static BusinessNode operatorRootNodeCreator(String val) {
        BusinessNode n = null;
        if (val.equalsIgnoreCase("AND")) {
            n = new AndOperator("AND");
        } else if (val.equalsIgnoreCase("OR")) {
            n = new OrOperator("OR");
        } else if (val.equalsIgnoreCase("NOT BLANK")) {
            n = new NotBlankOperator("NOT BLANK");
        } else if (val.equalsIgnoreCase("GREATER THAN")) {
            n = new GreaterThanOperator("GREATER THAN");
        }
        return n;
    }
}
