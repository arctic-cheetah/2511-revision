package bool;

public class BooleanOperator implements BooleanNode {
    private BooleanNode left = null;
    private BooleanNode right = null;
    private String operator = "";

    public BooleanOperator(String operator, BooleanNode left, BooleanNode right) {
        this.operator = operator;

        if (operator.equals("not")) {
            this.left = left;
            this.right = left;
        } else {
            this.left = left;
            this.right = right;
        }

    }

    public BooleanOperator(String operator, BooleanNode left) {
        this.operator = operator;
        this.left = left;
        this.right = left;
    }

    public BooleanOperator(String operator) {
        this.operator = operator;
    }

    public BooleanOperator() {
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
        return prettyBoolean(left.prettyBoolean(), right.prettyBoolean());
    }

    private boolean operateOn(boolean l, boolean r) {
        if (operator.equals("and")) {
            return l && r;
        } else if (operator.equals("or")) {
            return l || r;
        }
        // operator is not
        return !l;
    }

    public String prettyBoolean(String l, String r) {
        if (operator.equals("and")) {
            return "(AND" + " " + l + " " + r + ")";
        } else if (operator.equals("or")) {
            return "(OR" + " " + l + " " + r + ")";
        }
        // operator is not
        return "(NOT" + " " + l + ")";
    }

    // Getters and setters
    public void setLeft(BooleanNode left) {
        this.left = left;
    }

    public void setRight(BooleanNode right) {
        this.right = right;
    }

    public void setoperator(String operator) {
        this.operator = operator;
    }
}
