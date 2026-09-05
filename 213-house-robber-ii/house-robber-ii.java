class Solution {
    public int rob(int[] nums) {
        int[][] memo= new int[nums.length][2];
        for (int[] row : memo) Arrays.fill(row, -1);
        return f(memo,nums, 0,0);
    }
    int f(int[][] memo,int[] nums, int index, int flag) {
        if (index==nums.length-1) {
            if (flag==1) return 0;
            return nums[index];
        }
        if (index>=nums.length) return 0;
        if (memo[index][flag]!=-1) return memo[index][flag];
        int nf=flag;
        if(index==0) nf=1;
        int select = nums[index] + f(memo,nums, index+2, nf);
        int skip= f(memo, nums, index+1, flag);
        int max=Math.max(select, skip);
        return memo[index][flag]=max;
    }
}