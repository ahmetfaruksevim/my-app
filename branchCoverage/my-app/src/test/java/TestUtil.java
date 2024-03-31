import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestUtil {
    private Util util;

    @Before
    public void setUp() {
        util = new Util();
    }

    @Test
    public void testComputeSingleArg() {
        assertFalse(util.compute(5));
    }

    @Test
    public void testComputeEvenArgs() {
        assertFalse(util.compute(1, 2, 3, 4));
    }

    @Test(expected = RuntimeException.class)
    public void testComputeZeroArg() {
        util.compute(0, 1, 2);
    }

    @Test
    public void testComputeSumDivisibleByArg() {
        assertTrue(util.compute(2, 3, 4));
    }

    @Test
    public void testComputeSumNotDivisibleByArg() {
        assertFalse(util.compute(2, 3, 8));
    }

  
}
