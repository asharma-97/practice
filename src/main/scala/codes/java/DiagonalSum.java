package codes.java;

public class DiagonalSum {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (i != n - i - 1)
                sum += mat[i][n - i - 1];
        }
        return sum;
    }
}
