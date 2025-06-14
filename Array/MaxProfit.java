public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2};

        func2(prices);
    }

    public static int func(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] <= min){
                min = prices[i];
                int max = -1;

                for (int j = i+1; j < prices.length; j++) {
                    if(prices[j] > max){
                        max = prices[j];

                        profit = Math.max(profit, prices[j] - prices[i]);
                    }
                }
            }
        }

        System.out.println(profit);

        return profit;
    }

    public static int func2(int[] prices) {
        int buy = 0;
        int sell = 1;
        int profit = 0;

        while(sell < prices.length){
            if(prices[sell] > prices[buy]){
                profit = Math.max(profit, prices[sell] - prices[buy]);
            }else buy = sell;

            sell++;
        }

        System.out.println(profit);

        return profit;
    }
}
