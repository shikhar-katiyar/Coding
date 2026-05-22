class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo= new int [m+1][n+1];
        for (int[] row:memo) {
            Arrays.fill(row, -1);
        }
        return Path (m, n, memo);
    }
    public int Path(int m, int n, int[][] memo) {
        if (memo[m][n]!=-1) return memo[m][n];
        if (m==1 || n==1) return 1;
        int right = Path(m, n-1, memo);
        int down = Path(m-1, n, memo);
        return memo[m][n]= right + down;
    }
}