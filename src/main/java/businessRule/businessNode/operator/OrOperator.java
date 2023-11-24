package businessRule.businessNode.operator;

import java.util.List;

import businessRule.businessNode.BusinessNode;

public class OrOperator extends OperatorNode {
    public OrOperator(String rule) {
        super(rule);
    }

    public boolean evaluate() {
        List<BusinessNode> b = getArgs();
        return b.get(0).evaluate() || b.get(1).evaluate();
    }
}
