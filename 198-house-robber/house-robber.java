class Solution {
    public int rob(int[] nums) {
        int[] memo= new int[nums.length];
        Arrays.fill(memo, -1);
        return f(memo,nums, 0);
    }
    int f(int[] memo, int[] nums, int index) {
        if (index>=nums.length) return 0;
        if (memo[index]!=-1) return memo[index];
        int select = nums[index] + f(memo, nums, index+2);
        int skip= f(memo, nums, index+1);
        memo[index]=Math.max(select, skip);
        return memo[index];
    }
}