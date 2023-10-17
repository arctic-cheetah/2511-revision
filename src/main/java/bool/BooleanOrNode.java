package bool;

public class BooleanOrNode extends BooleanOperator {
    public String prettyBooleanString(String l, String r) {
        return "(OR" + " " + l + " " + r + ")";
    }

    public boolean operateOn(boolean l, boolean r) {
        return l || r;
    }

}
