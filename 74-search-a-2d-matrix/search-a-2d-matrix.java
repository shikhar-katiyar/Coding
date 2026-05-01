class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length, c= matrix[0].length;
        int low=0, high= r*c-1;
        while (low<=high){
            int mid=(low+high)/2;
            int m_row= mid/c, m_col=mid%c;
            if (matrix[m_row][m_col]== target) return true;
            else if (matrix[m_row][m_col]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}