package businessRule.businessNode.operator;

import java.util.List;

import businessRule.businessNode.BusinessNode;

public class NotBlankOperator extends OperatorNode {
    public NotBlankOperator(String rule) {
        super(rule);
    }

    public boolean evaluate() {
        List<BusinessNode> b = getArgs();
        return !b.get(0).evaluate();
    }

}
