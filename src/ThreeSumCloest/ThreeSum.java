package ThreeSumCloest;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int p1 = i + 1;
            int p2 = nums.length - 1;

            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if (sum > target) {
                    p2--;
                } else {
                    p1++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
