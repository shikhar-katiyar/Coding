class Solution {
    public int minCost(int[][] grid, int k) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int[][] memo = new int[grid.length * grid[0].length][5 * (k + 1)];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        ArrayList<Integer> p= new ArrayList<>();
        int ans= f(grid, 0, 0, memo, k, p);
        return ans >= 10000000 ?-1: ans;
    }
    private int f(int[][] grid, int i, int j, int[][] memo, int k, ArrayList<Integer> p) {
        int n=grid.length;
        int m=grid[0].length;
        if (i>=n || j>=m || i<0 || j<0 || k<0 || grid[i][j] == -1) return 10000000;
        if (i==n-1 && j==m-1) return grid[i][j];
        int d = p.isEmpty() ? 4 : p.get(p.size()-1);
        int row = (i * m) + j;
        int col = (d * (memo[0].length / 5)) + k;
        if (memo[row][col] != -1) return memo[row][col];
        int[] ans= new int[4];
        int temp = grid[i][j];
        grid[i][j] = -1;
        p.add(0); ans[0]= f(grid, i, j+1, memo, (d==4 || d==0) ? k :k-1, p); p.remove(p.size()-1);
        p.add(1); ans[1]= f(grid, i, j-1, memo, (d==4 || d==1) ? k :k-1, p); p.remove(p.size()-1);
        p.add(2); ans[2]= f(grid, i+1, j, memo, (d==4 || d==2) ? k: k-1, p); p.remove(p.size()-1);
        p.add(3); ans[3]= f(grid, i-1, j, memo, (d==4 || d==3) ? k: k-1, p); p.remove(p.size()-1);
        grid[i][j]=temp;
        int min= 10000000;
        for (int r=0; r<ans.length; r++) {
            if (ans[r]<min) min=ans[r];
        }
        return memo[row][col]=grid[i][j] + min;
    }
}