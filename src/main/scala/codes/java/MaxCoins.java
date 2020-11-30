//https://leetcode.com/problems/maximum-number-of-coins-you-can-get
package codes.java;

import java.util.Arrays;

public class MaxCoins {
    public static void main(String[] args) {

    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = piles.length - 2; i >= piles.length / 3; i -= 2) {
            sum += piles[i];
        }
        return sum;
    }
}
