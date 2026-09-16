class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        Integer[][] memo= new Integer[n][n];
        return f(s,0, n-1, memo);
    }
    int f(String s, int i, int j, Integer[][] memo) {
        if (i>j) return 0;
        if (i==j) return 1;
        if (memo[i][j] != null) return memo[i][j];
        if (s.charAt(i)==s.charAt(j)) {
            return memo[i][j]= 2 + f(s, i+1, j-1, memo);
        }
        return memo[i][j]=Math.max(f(s, i+1, j, memo), f(s, i, j-1, memo));
    }
}