package DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        func(coins, amount);
    }

    public static int func(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        minCoins[0] = 0;

        for (int i = 1; i < minCoins.length; i++) {
            Integer min = null;
            boolean canChange = false;
            for (int c : coins) {
                if(c <= i){
                    int remainder = i - c;
                    if(minCoins[remainder] != -1){
                        canChange = true;
                        min = min == null ? minCoins[remainder]+1 : Math.min(minCoins[remainder]+1, min);
                    }
                }
            }

            if(canChange){
                minCoins[i] = min;
            }else{
                minCoins[i] = -1;
            }
        }

        System.out.println(Arrays.toString(minCoins));

        return minCoins[amount];
    }
}
