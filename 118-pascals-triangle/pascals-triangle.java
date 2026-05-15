class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            res.add(new ArrayList<Integer>());
            for (int j=0; j<=i; j++){
                if (j==0 || j==i) res.get(i).add(1);
                else res.get(i).add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
        }
        return res;
    }
}