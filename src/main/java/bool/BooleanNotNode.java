package bool;

public class BooleanNotNode extends BooleanOperator {
    public String prettyBooleanString(String l, String r) {
        return "(NOT" + " " + l + ")";
    }

    public boolean operateOn(boolean l, boolean r) {
        return !l;
    }
}
