import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return lcs(s1, s2, 0, 0, memo);
    }
    
    private int lcs(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(
                lcs(s1, s2, i + 1, j, memo),
                lcs(s1, s2, i, j + 1, memo)
            );
        }
        return memo[i][j];
    }
}