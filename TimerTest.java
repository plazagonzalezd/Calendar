

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TimerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TimerTest
{
    private Timer timer1;

    /**
     * Default constructor for test class TimerTest
     */
    public TimerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        timer1 = new Timer(10, 10, 10, 10);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testTick()
    {
        timer1.timeTick();
        assertEquals("10:10:10:09", timer1.getTime());
    }

    @Test
    public void testSetIncorrectTime()
    {
        timer1.setTime(100, 10, 10, 10);
        assertEquals("10:10:10:10", timer1.getTime());
        timer1.setTime(10, 100, 10, 10);
        assertEquals("10:10:10:10", timer1.getTime());
        timer1.setTime(10, 10, 100, 10);
        assertEquals("10:10:10:10", timer1.getTime());
        timer1.setTime(10, 10, 10, 100);
        assertEquals("10:10:10:10", timer1.getTime());
    }

    @Test
    public void testSetTime()
    {
        timer1.setTime(10, 10, 10, 1);
        assertEquals("01:10:10:10", timer1.getTime());
    }

    @Test
    public void testZero()
    {
        assertEquals(false, timer1.zero());
    }

    @Test
    public void testDisplayTime()
    {
        assertEquals("10:10:10:10", timer1.getTime());
    }
}





