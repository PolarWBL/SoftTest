import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1,1);
        int expected = 2;
        assertEquals(result,expected);
    }

    @Test
    public void testSubtract(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(1,1);
        int expected = 0;
        assertEquals(result,expected);
    }

}
