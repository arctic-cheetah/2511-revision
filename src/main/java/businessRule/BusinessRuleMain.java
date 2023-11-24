package businessRule;

import java.util.HashMap;
import java.util.Map;

public class BusinessRuleMain {
    private static Map<String, Object> varLookUp = new HashMap<>();

    // public static void main(String[] args) {

    // }

    public static void setVarLookUp(Map<String, Object> varLookUp) {
        BusinessRuleMain.varLookUp = varLookUp;
    }

    public static Map<String, Object> getVarLookUp() {
        return varLookUp;
    }

}
