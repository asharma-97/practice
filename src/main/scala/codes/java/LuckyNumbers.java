package codes.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        Arrays.fill(row, Integer.MAX_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j])
                    l.add(matrix[i][j]);
            }
        }
        return l;
    }
}
