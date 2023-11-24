package businessRule.businessNode.operator;

import java.util.List;

import businessRule.businessNode.BusinessNode;
import businessRule.businessNode.value.ConstantNode;
import businessRule.businessNode.value.ValueNode;

public class GreaterThanOperator extends OperatorNode {
    public GreaterThanOperator(String rule) {
        super(rule);
    }

    public boolean evaluate() {
        List<BusinessNode> b = getArgs();
        ValueNode v1 = (ValueNode) b.get(0);
        ConstantNode v2 = (ConstantNode) b.get(1);
        Double val1 = Double.parseDouble(v1.getVal().toString());
        Double val2 = (Double) v2.getVal();
        return val1 > val2;
    }
}
