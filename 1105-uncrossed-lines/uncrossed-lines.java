class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] row:memo) {
            Arrays.fill(row, -1);
        }
        return f(nums1, nums2, 0, 0, memo);
    }
    private int f(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i>=nums1.length || j>=nums2.length) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (nums1[i]== nums2[j]) {
            return 1 + f(nums1 , nums2, i+1, j+1, memo);
        }else {
            memo[i][j]=Math.max(f(nums1, nums2, i+1, j, memo), f(nums1, nums2, i, j+1, memo));
        }
        return memo[i][j];
    }
}