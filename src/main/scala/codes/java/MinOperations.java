package codes.java;

public class MinOperations {
    public static void main(String[] args) {
    }
    public int minOperations(int n) {
        // if (n is even) => 1 + 3 + 5... 2(n/2 - 1) + 1
        // 1, 3, 5, 7, 9 => 2 + 4 + 6 +... 2(n/2)
        if(n == 1) return 0;
        if(n %2 == 0) return sumOfArithmeticSeq(1, n/2, 2);
        else return sumOfArithmeticSeq(2, n/2, 2);
    }
    public int sumOfArithmeticSeq(double a, double n, double d) {
        return (int)((n/2)*(2*a + (n-1)*d));
    }
}
