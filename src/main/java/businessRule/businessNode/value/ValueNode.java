package businessRule.businessNode.value;

import businessRule.businessNode.BusinessNode;

public interface ValueNode extends BusinessNode {
    public abstract String getArg();

    public abstract Object getVal();

    public abstract String getOperator();
}
