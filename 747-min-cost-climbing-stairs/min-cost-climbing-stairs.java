class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo= new int[cost.length];
        Arrays.fill(memo,-1);
        return Math.min(r(cost, 0, memo), r(cost, 1,memo));
    }
    private int r(int[] cost, int index, int[] memo) {
        if (index>=cost.length) return 0;
        if (memo[index]!=-1) return memo[index];
        int one= r(cost, index+1, memo);
        int two= r(cost, index+2, memo);
        return memo[index]=cost[index] + Math.min(one, two);
    }
}