package codes;

public class RestoreMatrix {
    public static void main(String[] args) {
        int[] rowSum = {5,7,10};
        int[] colSum = {8, 6, 8};
        restoreMatrix(rowSum, colSum);
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] mat = new int[rowSum.length][colSum.length];
        helper(mat, rowSum, colSum);
        return mat;
    }

    public static void helper(int[][] mat, int[] rowSum, int[] colSum) {
        for (int i = 0; i < rowSum.length; i++) {
            int rs = rowSum[i];
            for (int j = 0; j < colSum.length && rs > 0; j++) {
                int cs = colSum[j];
                if (cs <= rs) {
                    mat[i][j] = cs;
                    rs -= cs;
                    colSum[j] = 0;
                } else {
                    mat[i][j] = rs;
                    colSum[j] = cs - rs;
                    rs = 0;
                }
            }
        }
    }

//    public int[][] restoreMatrix(int[] row, int[] col) {
//        int m = row.length, n = col.length, i = 0, j = 0, a;
//        int[][] A = new int[m][n];
//        while (i < m && j < n) {
//            a = A[i][j] = Math.min(row[i], col[j]);
//            if ((row[i] -= a) == 0) ++i;
//            if ((col[j] -= a) == 0) ++j;
//        }
//        return A;
//    }
}
