package codes.java;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        FindDuplicates fd = new FindDuplicates();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        fd.findDuplicates(arr);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) l.add(Math.abs(nums[i]));
            else nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return l;
    }
}
