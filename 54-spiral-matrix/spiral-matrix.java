class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int fr=0, lr=matrix.length-1, fc=0, lc=matrix[0].length-1;
        ArrayList<Integer> res =new ArrayList<>();
        while (fr<=lr && fc<=lc){
            for (int i=fc; i<=lc; i++){
                res.add(matrix[fr][i]);
            }
            fr++;
            for (int i=fr; i<=lr; i++){
                res.add(matrix[i][lc]);
            }
            lc--;
            if (fr<=lr){
                for (int i=lc; i>=fc; i--){
                    res.add(matrix[lr][i]);
                }
                lr--;
            }
            if (fc<=lc){
                for (int i=lr; i>=fr; i--){
                    res.add(matrix[i][fc]);
                }
                fc++;
            }
        }
        return res;
    }
}