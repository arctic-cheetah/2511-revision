package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    private static final int ROUNDS = 1_000_000;
    private static final double LOWER = 0.49;
    private static final double UPPER = 0.51;

    private List<Boolean> getDataWins(Game g) {
        List<Boolean> dat = new ArrayList<Boolean>();
        for (int i = 0; i < ROUNDS; i++) {
            dat.add(g.battle());
        }
        return dat;
    }

    private boolean toleranceRange(Double numWins) {
        return LOWER <= numWins / ROUNDS && numWins / ROUNDS <= UPPER;
    }

    @Test
    public void test1() {
        // Set tolerance to be at 1% or ±1
        Game g = new Game(4);
        List<Boolean> dat = getDataWins(g);
        // Count all the trues
        Double numWins = dat.stream().filter(e -> e.booleanValue()).mapToDouble(e -> 1).reduce(0, Double::sum);
        assertTrue(toleranceRange(numWins));
    }

    @Test
    public void test2() {
        // Set tolerance to be at 1% or ±1
        Game g = new Game(0);
        List<Boolean> dat = getDataWins(g);
        // Count all the trues
        double numWins = dat.stream().filter(e -> e.booleanValue()).mapToDouble(e -> 1).reduce(0, Double::sum);
        assertTrue(toleranceRange(numWins));
    }

    @Test
    public void test3() {
        // Set tolerance to be at 1% or ±1
        Game g = new Game();
        List<Boolean> dat = getDataWins(g);
        // Count all the trues
        double numWins = dat.stream().filter(e -> e.booleanValue()).mapToDouble(e -> 1).reduce(0, Double::sum);
        assertTrue(toleranceRange(numWins));
    }

}
