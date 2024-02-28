package salescommissioncalculator;

public class SalesCommissionCalculator {

    public static void main(String[] args) {

        int[] sales = {50000, 100000, 25000, 10000, 80000}; //initializing an array called sales and its value.

        int totalSales = 0;                                 // initializing the variable totalSales is equal to zero.

        for (int sale : sales) {                            // using the method "for loop" to sum up all sales.
            totalSales += sale;
        }

        double CommisionRate;                               // initializing the variable commisionrate using  a double method.

        if (totalSales <= 100000) {                         //using the conditional, it emphasize if a one statement is correct it will  grant them the given rates.
            CommisionRate = 0.05;
        } else if (totalSales <= 200000) {
            CommisionRate = 0.08;
        } else {
            CommisionRate = 0.10;
        }

        double CommisionEarned = totalSales * CommisionRate;     //initializing the variable CommisionEarned using double, it emphasize the totalSales multiply by CommisionRate

        System.out.println("Total sales amount:" + "P" + totalSales);               // Displaying the total amount of sales.
        System.out.println("Commission rate:" + (CommisionRate * 100) + "%");      // Displaying the total commision Rates.
        System.out.println("Commission earned:" + "P" + CommisionEarned);          // Displaying the total commision earned.

    }
}
