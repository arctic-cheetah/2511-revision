package bool;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;
import com.google.gson.JsonParser;

public class BooleanEvaluator {
    public static boolean evaluate(BooleanNode expression) {
        // Return the expression evaluated
        return expression.evaluteExpression();
    }

    public static String prettyPrint(BooleanNode expression) {
        // Pretty print the expression
        return expression.prettyBoolean();
    }

    // Helper method to read json data
    private static String readInData(String filename) {
        try {
            URI path = BooleanEvaluator.class.getResource(filename).toURI();
            return new String(Files.readAllBytes(Path.of(path)));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        BooleanVariable t1 = new BooleanVariable(true);
        BooleanVariable t2 = new BooleanVariable(false);
        BooleanOperator not1 = new BooleanOperator("not", t1);

        BooleanOperator ex1 = new BooleanOperator("or", not1, t2);
        BooleanNode n1 = ex1;

        System.out.println(BooleanEvaluator.evaluate(n1));
        System.out.println(BooleanEvaluator.prettyPrint(n1));

        String jsonString = readInData("data2.json");
        String tmp = JsonParser.parseString(jsonString).getAsJsonObject().toString();
        JSONObject j = new JSONObject(tmp);

        BooleanNode n2 = NodeFactory.getBooleanNode(j);
        System.out.println(n2.prettyBoolean());
        System.out.println(n2.evaluteExpression());

    }

}
