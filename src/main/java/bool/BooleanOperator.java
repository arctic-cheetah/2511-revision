package bool;

public abstract class BooleanOperator implements BooleanNode {
    private BooleanNode left = null;
    private BooleanNode right = null;

    public static BooleanOperator createBooleanOperator(String operator) {
        if (operator.equalsIgnoreCase("and"))
            return new BooleanAndNode();
        else if (operator.equalsIgnoreCase("or")) {
            return new BooleanOrNode();
        } else {
            return new BooleanNotNode();
        }

    }

    public BooleanNode getLeft() {
        return left;
    }

    public BooleanNode getRight() {
        return right;
    }

    public boolean evaluteExpression() {
        return operateOn(left.evaluteExpression(), right.evaluteExpression());
    }

    public String prettyBoolean() {
        return prettyBooleanString(left.prettyBoolean(), right.prettyBoolean());
    }

    public abstract boolean operateOn(boolean l, boolean r);

    public abstract String prettyBooleanString(String l, String r);

    // Getters and setters
    public void setLeft(BooleanNode left) {
        this.left = left;
    }

    public void setRight(BooleanNode right) {
        this.right = right;
    }

}
