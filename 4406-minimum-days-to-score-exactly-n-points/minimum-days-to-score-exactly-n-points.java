class Solution {
    private int[][] memo; 
    public int minDays(int n) {
        int maxStreak = (int) Math.sqrt(2 * n) + 5;
        memo = new int[n + 1][maxStreak];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }
        return f(n, 1);
    }

    private int f(int s, int i) {
        if (s == 0) return 0;
        if (s < 0) return (int) 1e9; 
        if (memo[s][i] != -1) {
            return memo[s][i];
        }
        int a = 1 + f(s - i, i + 1);
        int b = 2 + f(s - 1, 2);
        return memo[s][i] = Math.min(a, b);
    }
}