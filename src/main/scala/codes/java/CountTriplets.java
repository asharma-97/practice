package codes.java;

public class CountTriplets {
    public static void main(String[] args) {
        CountTriplets ct = new CountTriplets();
        int[] arr = {2, 3, 1, 6, 7};
        ct.countTriplets(arr);
    }

    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += (j-i);
                }
            }
        }
        return ans;
    }
}
