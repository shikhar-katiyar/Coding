class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int[][] memo= new int [m+1][n+1];
        for (int[] row:memo) {
            Arrays.fill(row, -1);
        }
        return Path (m, n, memo,obstacleGrid);
    }
    public int Path(int m, int n, int[][] memo, int[][] obstacleGrid) {
        if (m==0 || n==0 || obstacleGrid[obstacleGrid.length-m][obstacleGrid[0].length-n]==1) return 0;
        if (memo[m][n]!=-1) return memo[m][n];
        if (m==1 && n==1) return 1;
        int right = Path(m, n-1, memo, obstacleGrid);
        int down = Path(m-1, n, memo,obstacleGrid);
        return memo[m][n]= right + down;
    }
}
