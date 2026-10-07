class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] m= new int[matrix[0].length];
        for(int i=0; i<matrix[0].length;i++){
            int max= matrix[0][i];
            for (int j=0;j<matrix.length;j++){
                max= Math.max(max,matrix[j][i]);
            }
            m[i]=max;
        }
        int min=10000000;
        for (int i=0; i<m.length; i++){
            if (m[i]<min) min=m[i];
        }
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0; i<matrix.length;i++){
            int ma= matrix[i][0];
            for (int j=0;j<matrix[0].length;j++){
                ma= Math.min(ma,matrix[i][j]);
            }
            if (ma==min){
                res.add(min);
                return res;
            }
        }
        return res;
    }
}