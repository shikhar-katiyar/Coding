class Solution {
    public int uniquePathsIII(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int a=0, b=0, e=1;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    a=i;
                    b=j;
                }
                else if (grid[i][j]==0) e++;
            }
        }
        return (int) f(grid, a, b, e);
    }
    private long f(int[][] grid, int i, int j, int e) {
        long n= grid.length;
        long m= grid[0].length;
        if (i>=n || j>=m || i<0 || j<0 || grid[i][j]==-1) return 0;
        if (grid[i][j]==2) return e==0?1:0;
        int temp = grid[i][j];
        grid[i][j] = -1;
        long right= f(grid, i, j+1, e-1);
        long left= f(grid, i, j-1, e-1);
        long down= f(grid, i+1, j, e-1);
        long up= f(grid, i-1, j, e-1);
        grid[i][j]=temp;
        return right+left + down + up;
    }
}