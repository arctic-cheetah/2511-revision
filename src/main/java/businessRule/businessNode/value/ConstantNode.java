package businessRule.businessNode.value;

public class ConstantNode implements ValueNode {
    private String arg = "";
    private String operator = "CONSTANT";
    private Number val = null;

    public ConstantNode(Number val) {
        this.val = val;
    }

    public String getArg() {
        return this.arg;
    }

    public Number getVal() {
        return val;
    }

    public String getOperator() {
        return operator;
    }

    public boolean evaluate() {
        return val == null ? false : true;
    }
}
