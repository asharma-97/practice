package codes.java;

import java.util.Arrays;
import java.util.HashMap;

public class CanFormArray {
    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78}, {91}, {4,64}};
        System.out.println(canFormArray(arr, pieces));
    }
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        int[] emptyArray = {};
        for (int[] piece : pieces) {
            hm.put(piece[0], piece);
        }
        int[] ret = new int[arr.length];
        for(int i = 0; i< arr.length; i++) {
            int[] fromMap = hm.getOrDefault(arr[i], emptyArray);
            for (int k : fromMap) {
                if(i > arr.length - 1) return false;
                ret[i] = k;
                i++;
            }
            if(fromMap.length != 0)
                i--;
        }

        return Arrays.equals(ret, arr);
    }
}
