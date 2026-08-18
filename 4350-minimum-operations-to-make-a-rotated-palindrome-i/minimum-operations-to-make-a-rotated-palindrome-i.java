class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int minTotal= Integer.MAX_VALUE;;
        for (int k=0; k<n; k++){
            int current=k;
            for (int i=0;i<n/2;i++){
                char c1 = s.charAt((i + k) % n);
                char c2 = s.charAt((n - 1 - i + k) % n);
                int diff = Math.abs(c1 - c2);
                current += Math.min(diff, 26 - diff);
            }
            if (current < minTotal) {
                minTotal = current;
            }
        }
        return minTotal;
    }
}
