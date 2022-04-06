package triangle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TriangleTest {
    Triangle triangle;
    int a;
    int b;
    int c;
    String expected;

    public TriangleTest(int a, int b, int c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection triangleTestCase(){
        return Arrays.asList(new Object[][]{
                {0,50,50,"输入错误"},
                {1,50,50,"等腰三角形"},
                {2,50,50,"等腰三角形"},
                {99,50,50,"等腰三角形"},
                {100,50,50,"非三角形"},
                {101,50,50,"输入错误"},
                {50,0,50,"输入错误"},
                {50,1,50,"等腰三角形"},
                {50,2,50,"等腰三角形"},
                {50,99,50,"等腰三角形"},
                {50,100,50,"非三角形"},
                {50,101,50,"输入错误"},
                {50,50,0,"输入错误"},
                {50,50,1,"等腰三角形"},
                {50,50,2,"等腰三角形"},
                {50,50,99,"等腰三角形"},
                {50,50,100,"非三角形"},
                {50,50,101,"输入错误"},
                {49,50,51,"一般三角形"}
        });
    }

    @Test
    public void testTriangle(){
        triangle = new Triangle();
        Assert.assertEquals(expected, triangle.isTriangle(a,b,c));
    }
}
