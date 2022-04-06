import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commission {
    public String CommissionProblem(int locks, int stocks,int barrels){
        double lockPrice, stockPrice, barrelPrice;
        double lockSales, stockSales, barrelSales;
        double sales, commission;

        lockPrice = 45.0;
        stockPrice = 30.0;
        barrelPrice = 25.0;

        if (locks == -1){
            return "程序终止";
        } else if (locks < 1 || locks>70 ) {
            return "locks的取值不在有效范围1~70内";
        } else if (stocks<1 || stocks>80 ) {
            return "stocks的取值不在有效范围1~80内";
        } else if (barrels<1 || barrels>90 ) {
            return "barrels的取值不在有效范围1~90内";
        }else {
            lockSales = lockPrice * locks;
            stockSales = stockPrice * stocks;
            barrelSales = barrelPrice * barrels;
            sales = lockSales + stockSales + barrelSales;

            if (sales > 1800.0){
                commission = 0.10 * 1000.0;
                commission = commission + 0.15 * 800.0;
                commission = commission +
                        0.20 * (sales-1800.0);
            } else if (sales >1000.0) {
                commission = 0.10 * 1000.0;
                commission = commission
                        + 0.15* (sales-1000.0);
            }else {
                commission = 0.10 * sales;
            }

            return commission + "美元";
        }

    }

    public static void main(String[] args) {
        Commission commission = new Commission();
        List<int[]> list = Arrays.asList(new int[][]{
                {1,37,4},
                {14,3,114},
                {61,9,-10},
                {63,92,23},
                {46,84,116},
                {51,91,-26},
                {44,-23,35},
                {53,-13,104},
                {13,-12,-8},
                {93,39,65},
                {74,66,99},
                {71,20,-19},
                {84,82,82},
                {83,81,97},
                {92,88,-3},
                {86,-10,69},
                {89,-22,94},
                {75,-2,-9},
                {-11,36,17},
                {-15,78,111},
                {-8,24,-16},
                {-3,89,36},
                {-14,98,95},
                {-19,83,-24},
                {-10,-7,68},
                {-7,-15,100},
                {-6,-6,-6}
        });
        int locks,  stocks, barrels;
        for (int[] ints : list) {
            locks = ints[0];
            stocks = ints[1];
            barrels = ints[2];
//            System.out.println("("+locks+"," +stocks+","+barrels+")");
            System.out.println(commission.CommissionProblem(locks,stocks,barrels));
        }



    }
}
