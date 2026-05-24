class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        sets("", nums, 0, res);
        return res;
    }
    private static void sets(String ans, int[] nums, int idx, List<List<Integer>> res){
        if (idx==nums.length){
            List<Integer> list = new ArrayList<>();
            if (!ans.isEmpty()) {
                for (String s : ans.split(" ")) {
                    list.add(Integer.parseInt(s));
                }
            }
            res.add(list);
            return;
        }
        sets(ans+nums[idx]+ " ", nums, idx+1, res);
        sets(ans, nums, idx+1, res);
    }
}