import java.util.Arrays; 
class Solution {
    public int rob(int[] nums) {
        int[] memo= new int[nums.length];
        Arrays.fill(memo, -1);
        return ro(nums, 0, memo);
    }
    private int ro(int[] nums, int index, int[] memo) {
        if (index>=nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int select= nums[index] + ro(nums, index +2, memo);
        int skip= ro(nums, index +1, memo);
        return memo[index]= Math.max(select, skip);
    }
}