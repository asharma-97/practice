package codes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckArithmeticSubArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        int[] l = new int[]{0, 1, 6, 4, 8, 7};
        int[] r = new int[]{4, 4, 9, 7, 9, 10};
        checkArithmeticSubarrays(arr, l, r);
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ll = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ll.add(checkArithmeticArray(nums, l[i], r[i]));
        }
        return ll;
    }

    public static boolean checkArithmeticArray(int[] arr, int l, int r) {
        if (r - l <= 1) return true;
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }
        int interval = (max - min) / (r - l);
        if ((max - min) % (r - l) != 0) return false;
        for (int i = 1; i < r - l; i++) {
            if (!set.contains(min + i * interval)) return false;
        }
        return true;
    }
}
