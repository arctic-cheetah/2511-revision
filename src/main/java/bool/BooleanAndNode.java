package bool;

public class BooleanAndNode extends BooleanOperator {
    public String prettyBooleanString(String l, String r) {
        return "(AND" + " " + l + " " + r + ")";
    }

    public boolean operateOn(boolean l, boolean r) {
        return l && r;
    }
}
