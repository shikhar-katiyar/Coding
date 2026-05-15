class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int i=0, j=n-1;
        while (j>=0 && i<m){
            if (matrix[i][j]<target) i++;
            else if (matrix[i][j]>target) j--;
            else if (matrix[i][j]==target) return true;
        }
        return false;
    }
}