class Solution {
    public int arrangeCoins(int n) {
        long low=0, high=n, a=-1;
        while(low<=high) {
            long mid=low+(high-low)/2;
            long sum= mid*(mid+1)/2;
            if (sum<=n){
                a=mid;
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return (int) a;
    }
}