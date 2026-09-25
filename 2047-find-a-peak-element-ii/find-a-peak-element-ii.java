class Solution {
    public int[] findPeakGrid(int[][] mat) {
        for (int i=0; i<mat.length;i++){
            for (int j=0; j<mat[0].length;j++){
                int left= (j>0) ? mat[i][j-1] : -1;
                int right=(j<mat[0].length-1) ? mat[i][j+1] : -1;
                int top = (i>0) ? mat[i-1][j] :-1;
                int down=(i<mat.length-1) ? mat[i+1][j] : -1;
                if (mat[i][j]>left && mat[i][j]> right && mat[i][j]>top && mat[i][j]>down) return new int[]{i, j};
            }
        }
        return new int[]{-1,-1};
    }
}