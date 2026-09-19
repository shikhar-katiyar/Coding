class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo= new int[nums.length][nums.length+1];
        for (int[] row:memo) {
            Arrays.fill(row, -1);
        }
        return f(nums, 0, -1, memo);
    }
    public int f(int[] nums, int i, int p, int[][] memo) {
        if (i>=nums.length) return 0;
        if (memo[i][p+1]!=-1) return memo[i][p+1];
        int a=0;
        if (p==-1 || nums[i]>nums[p]){
            a=1+f(nums,i+1, i, memo);
        }
        int b= f(nums, i+1, p, memo);
        return memo[i][p+1]=Math.max(a, b);
    }
}