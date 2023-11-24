package businessRule.businessNode.value;

import businessRule.BusinessRuleMain;

public class LookUpNode implements ValueNode {
    private String arg = "";
    private String operator = "LOOKUP";
    private Object val = null;

    public LookUpNode(String arg) {
        this.arg = arg;
        this.val = BusinessRuleMain.getVarLookUp().get(arg);
    }

    public String getArg() {
        return this.arg;
    }

    public Object getVal() {
        return val;
    }

    public String getOperator() {
        return operator;
    }

    // Not Blank
    public boolean evaluate() {
        return val.toString().isBlank();
    }

}
