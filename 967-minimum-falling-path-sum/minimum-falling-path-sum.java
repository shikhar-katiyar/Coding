class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] memo= new int[grid.length][grid[0].length];
        for (int[] i: memo) {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for (int j=0; j<grid[0].length; j++){
            ans=Math.min(ans, f(grid, 0, j, memo));
        }
        return ans;
    }
    public int f(int[][] grid, int i, int j, int[][] memo) {
        if (i>=grid.length || j>=grid[0].length || j<0) return Integer.MAX_VALUE;
        if (i==grid.length-1) return grid[i][j];
        if (memo[i][j] != Integer.MAX_VALUE) return memo[i][j];
        int left= f(grid, i+1, j-1, memo);
        int right= f(grid, i+1, j+1, memo);
        int down= f(grid, i+1, j, memo);
        memo[i][j]= grid[i][j] + Math.min(left, Math.min(right, down));
        return memo[i][j];
    }
}