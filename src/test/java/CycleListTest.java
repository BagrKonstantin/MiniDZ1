import org.example.CycleList;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;

public final class CycleListTest {
    private final CycleList<Integer> cycleList1 = new CycleList<>(new ArrayList<>() {
        {
            add(1);
            add(2);
            add(3);
        }
    });

    private final CycleList cycleList2 = new CycleList();

    private final CycleList<Integer> cycleList3 = new CycleList<>(new ArrayList<>() {
        {
            add(2);
            add(3);
            add(1);
        }
    });

    private final CycleList<Integer> cycleList4 = new CycleList<>(new ArrayList<>() {
        {
            add(2);
            add(1);
        }
    });

    private final CycleList<String> cycleList5 = new CycleList<>(new ArrayList<>() {
        {
            add("a");
            add("Bab");
        }
    });


    @Test
    @Order(1)
    public void testEqualsEqual() {
        assertEquals(cycleList1, cycleList1);
    }

    @Test
    @Order(2)
    public void noMatchingSizesTest() {
        assertNotEquals(cycleList1, cycleList2);
    }

    @Test
    @Order(3)
    public void testEqualsDifferentTypes() {
        assertNotEquals(cycleList1, cycleList2);
    }


    @Test
    @Order(4)
    public void moveByTest() {
        assertEquals(cycleList1.moveBy(1), cycleList3);
    }

    @Test
    @Order(5)
    public void cyclicTest() {
        for (int i = 0; i < cycleList1.size(); i++) {
            assertEquals(cycleList1.get(i), cycleList1.get(i + cycleList1.size()));

        }
    }

    @Test
    @Order(6)
    public void cyclicTestNegative() {
        for (int i = 0; i < cycleList1.size(); i++) {
            assertEquals(cycleList1.get(i), cycleList1.get(i - cycleList1.size()));

        }
    }


    @Test
    @Order(7)
    public void toStringEqualsTest() {
        assertEquals(cycleList1.toString(), "[1, 2, 3, ]");
    }
}