class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1); 
        return f(arr, 0, n);
    }
    private int f(int[] arr, int c, int k) {
        if (c==k) return 1;
        if (c>k) return 0;
        if (arr[c] != -1) {
            return arr[c];
        }
        arr[c]= f(arr, c+1,k) + f(arr, c+2, k);
        return arr[c];
    }
}