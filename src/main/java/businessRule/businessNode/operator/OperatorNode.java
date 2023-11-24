package businessRule.businessNode.operator;

import java.util.List;

import businessRule.businessNode.BusinessNode;

public abstract class OperatorNode implements BusinessNode {
    private String operator = "";
    private List<BusinessNode> args = null;

    public OperatorNode(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }

    public List<BusinessNode> getArgs() {
        return this.args;
    }

    public void setArgs(List<BusinessNode> args) {
        this.args = args;
    }

    public abstract boolean evaluate();

}
