import java.util.Arrays;
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m][n];
        for (int[] ro : memo) {
            Arrays.fill(ro, -1);
        }
        int a=lcs(s1, s2, 0, 0, memo);
        int t1=0;
        for (int g=0;g<s1.length(); g++){
            t1+= (int) s1.charAt(g);
        }
        int t2=0;
        for (int g=0; g<s2.length(); g++){
            t1+= (int) s2.charAt(g);
        }
        int r= t1+t2-(2*a);
        return r;
    }
    private int lcs(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = (int) s1.charAt(i) + lcs(s1, s2, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(
                lcs(s1, s2, i + 1, j, memo),
                lcs(s1, s2, i, j + 1, memo)
            );
        }
        return memo[i][j];
    }
}