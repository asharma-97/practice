package codes.java;

public class FirstOccurrence {
    public static void main(String[] args) {
        System.out.println(firstOccurrence("aabc", "aa"));
    }

    public static int firstOccurrence(String s, String x) {
        int M = x.length();
        int N = s.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(x, M, lps);

        int i = 0;
        while (i < N) {
            if (x.charAt(j) == s.charAt(i) || x.charAt(j) == '*') {
                j++;
                i++;
            }
            if (j == M) {
                return (i-j);
            }
            else if (i < N && (x.charAt(j) != '*' && x.charAt(j) != s.charAt(i))) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return -1;
    }

    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len) || pat.charAt(i) == '*') {
                len++;
                lps[i] = len;
                i++;
            } else
            {
                if (len != 0) {
                    len = lps[len - 1];
                } else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
