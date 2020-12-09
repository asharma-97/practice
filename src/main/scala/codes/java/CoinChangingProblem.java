package codes.java;

public class CoinChangingProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 8};
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int total) {
        int[][] dp = new int[coins.length][total + 1];
        for (int i = 0; i < coins.length; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= total; j++) {
            if (coins[0] <= j) {
                if (j % coins[0] == 0)
                    dp[0][j] = dp[0][j - coins[0]] + 1;
            }

        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (coins[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i - 1][j]);
                }
            }
        }
        return dp[coins.length - 1][total];
    }
}
