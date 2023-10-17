package bool;

public class BooleanRootNode extends BooleanOperator {
    public String prettyBooleanString(String l, String r) {
        return "( " + l + " " + r + ")";
    }

    public boolean operateOn(boolean l, boolean r) {
        return true;
    }
}
