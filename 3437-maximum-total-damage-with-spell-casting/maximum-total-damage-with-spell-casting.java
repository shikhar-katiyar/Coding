class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n=power.length;
        int i=0;
        int size=0;
        long data[][] = new long[n][2];
        while (i<n) {
            int c=power[i];
            int count=0;
            while(i<n && power[i]==c){
                count++;
                i++;
            }
            data[size][0]=c;
            data[size][1]=count;
            size++;
        }
        long[] dp= new long[size+1];
        int j=0;
        for(int k=0;k<size;k++) {
            long d=data[k][0]*data[k][1];
            while (j<k && data[j][0]<data[k][0]-2){
                j++;
            }
            dp[k + 1] = Math.max(dp[k], d + dp[j]);
        }
        return dp[size];
    }
}