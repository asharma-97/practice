package codes.java;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(arr);
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        if(n==0) return A;
        int m = A[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                int a = A[i][j];
                int b = A[i][m - j - 1];
                A[i][j] = flip(b);
                A[i][m - j - 1] = flip(a);
            }
        }
        // handling odd case, where middle column is not filled
        if(A[0].length % 2 == 1) {
            for(int i=0; i<n; i++) {
                A[i][m/2] = flip(A[i][m/2]);
            }
        }
        return A;
    }
    public static int flip(int a) {
        if(a == 0) return 1;
        else return 0;
    }
}
