import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CommissionTest {
    Commission commission;
    int locks;
    int stocks;
    int barrels;
    String expected;

    public CommissionTest(int locks, int stocks, int barrels, String expected) {
        this.locks = locks;
        this.stocks = stocks;
        this.barrels = barrels;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection CommissionCollection(){
        return Arrays.asList(new Object[][]{
                {10,10,10,"100.0美元"},
                {20,30,0,"barrels的取值不在有效范围1~90内"},
                {40,100,22,"stocks的取值不在有效范围1~80内"},
                {120,60,80,"locks的取值不在有效范围1~70内"},
                {1,37,4,"138.25美元"},
                {14,3,114,"barrels的取值不在有效范围1~90内"},
                {61,9,-10,"barrels的取值不在有效范围1~90内"},
                {63,92,23,"stocks的取值不在有效范围1~80内"},
                {46,84,116,"stocks的取值不在有效范围1~80内"},
                {51,91,-26,"stocks的取值不在有效范围1~80内"},
                {44,-23,35,"stocks的取值不在有效范围1~80内"},
                {53,-13,104,"stocks的取值不在有效范围1~80内"},
                {13,-12,-8,"stocks的取值不在有效范围1~80内"},
                {93,39,65,"locks的取值不在有效范围1~70内"},
                {74,66,99,"locks的取值不在有效范围1~70内"},
                {71,20,-19,"locks的取值不在有效范围1~70内"},
                {84,82,82,"locks的取值不在有效范围1~70内"},
                {83,81,97,"locks的取值不在有效范围1~70内"},
                {92,88,-3,"locks的取值不在有效范围1~70内"},
                {86,-10,69,"locks的取值不在有效范围1~70内"},
                {89,-22,94,"locks的取值不在有效范围1~70内"},
                {75,-2,-9,"locks的取值不在有效范围1~70内"},
                {-11,36,17,"locks的取值不在有效范围1~70内"},
                {-15,78,111,"locks的取值不在有效范围1~70内"},
                {-8,24,-16,"locks的取值不在有效范围1~70内"},
                {-3,89,36,"locks的取值不在有效范围1~70内"},
                {-14,98,95,"locks的取值不在有效范围1~70内"},
                {-19,83,-24,"locks的取值不在有效范围1~70内"},
                {-10,-7,68,"locks的取值不在有效范围1~70内"},
                {-7,-15,100,"locks的取值不在有效范围1~70内"},
                {-6,-6,-6,"locks的取值不在有效范围1~70内"}
        });
    }

    @Test
    public void testCommission(){
        Commission commission = new Commission();
        Assert.assertEquals(expected, commission.CommissionProblem(locks,stocks,barrels));
    }

}