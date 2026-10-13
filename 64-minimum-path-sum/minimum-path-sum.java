class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo= new int[grid.length][grid[0].length];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }
        return f(grid, 0, 0, memo);
    }
    public int f(int[][] grid, int i, int j, int[][] memo) {
        if (i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if (i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if (memo[i][j] != -1) return memo[i][j];
        int right= f(grid, i, j+1, memo);
        int down= f(grid, i+1, j, memo);
        memo[i][j]= grid[i][j] + Math.min(right, down);
        return memo[i][j];
    }
}