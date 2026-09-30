import java.util.*;
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Boolean[][][] memo= new Boolean[row][col][row+col];
        if ((row+col-1)%2 !=0) return false;
        return p(grid, memo, 0, 0, 0);
    }
    private boolean p(char[][] grid,Boolean[][][] memo, int a, int b, int bal) {
        int row=grid.length;
        int col=grid[0].length;
        if (grid[a][b]=='('){
            bal++;
        }else{
            bal--;
        }
        if(bal<0) return false;
        if(a==row-1 && b==col-1) return bal==0;
        if (memo[a][b][bal] != null) return memo[a][b][bal];
        boolean f=false;
        if (a+1<row){
            f= f || p(grid,memo, a+1, b, bal);
        }
        if(b+1<col){
            f=f || p(grid,memo, a, b+1, bal);
        }
        return memo[a][b][bal]=f;
    }
}