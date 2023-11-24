package business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import businessRule.BusinessFactory;
import businessRule.BusinessRuleMain;
import businessRule.businessNode.BusinessNode;

public class BusinessTest {
    private static Map<String, Object> varLookup = new HashMap<>();

    @BeforeAll
    private static void setup() {
        varLookup.put("email", "temp@hotmail.com");
        varLookup.put("phoneNumber", 123456);
        varLookup.put("responses", 5);
        BusinessRuleMain.setVarLookUp(varLookup);
    }

    @Test
    public void testNodes1() {
        String res = "";
        try {
            res = BusinessFactory.loadResourceFile("dat1.json");
        } catch (Exception e) {
        }
        BusinessNode n = BusinessFactory.businessNodeFromJson(res);
        assertEquals(n.evaluate(), true);
    }

    @Test
    public void testNodes2() {
        String res = "";
        try {
            res = BusinessFactory.loadResourceFile("dat2.json");
        } catch (Exception e) {
        }
        BusinessNode n = BusinessFactory.businessNodeFromJson(res);
        assertEquals(n.evaluate(), true);
    }

    @Test
    public void testNodes3() {
        varLookup.put("responses", 1);
        String res = "";
        try {
            res = BusinessFactory.loadResourceFile("dat2.json");
        } catch (Exception e) {
        }
        BusinessNode n = BusinessFactory.businessNodeFromJson(res);
        assertEquals(n.evaluate(), false);
    }
}
