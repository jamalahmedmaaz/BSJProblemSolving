package jamal.dynamicprogramming;

public class CuttingRod {

    public static void main(String[] args) {
        CuttingRod cuttingRod = new CuttingRod();
        System.out.println(cuttingRod.maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    }


    private int maxProfit(int[] prices) {
        return maxProfit(prices, prices.length);
    }

    private int maxProfit(int[] prices, int remainingLengthOfRod) {

        if (remainingLengthOfRod <= 0) {
            return 0;
        }

        int max_profit = Integer.MIN_VALUE;

        for (int i = 0; i < remainingLengthOfRod; i++) {
            max_profit = Math.max(max_profit, prices[i] + maxProfit(prices, remainingLengthOfRod - i - 1));
        }


        return max_profit;
    }

}
