package bool;

public class BooleanVariable implements BooleanNode {
    boolean value;

    BooleanVariable(boolean value) {
        this.value = value;
    }

    BooleanVariable(String value) {
        this.value = value.equalsIgnoreCase("true") ? true : false;
    }

    public boolean evaluteExpression() {
        return value;
    }

    public String prettyBoolean() {
        return value ? "true" : "false";
    }
}
