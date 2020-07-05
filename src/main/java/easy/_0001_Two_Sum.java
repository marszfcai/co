package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _0001_Two_Sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> bucks = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int tmp = target - nums[i];
                if (bucks.containsKey(tmp)) {
                    return new int[]{bucks.get(tmp), i};
                }
                bucks.put(nums[i], i);
            }
            throw new IllegalArgumentException("cannot found any match nums!");
        }
    }
}
