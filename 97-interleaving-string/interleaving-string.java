class Solution { 
    public boolean isInterleave(String s1, String s2, String s3) { 
        if (s1.length() + s2.length() != s3.length()) { 
            return false; 
        } 
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1]; 
        return lcs(s1, s2, s3, 0, 0, 0, memo); 
    } 

    private boolean lcs(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) { 
        if (k == s3.length()) { 
            return true; 
        } 
        if (memo[i][j] != null) { 
            return memo[i][j]; 
        } 
        
        boolean m1 = false; 
        boolean m2 = false; 

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) { 
            m1 = lcs(s1, s2, s3, i + 1, j, k + 1, memo); 
        } 

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) { 
            m2 = lcs(s1, s2, s3, i, j + 1, k + 1, memo); 
        } 

        return memo[i][j] = (m1 || m2); 
    }
}
