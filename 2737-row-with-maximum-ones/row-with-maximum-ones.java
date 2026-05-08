class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int[] temp= new int[arr.length];
        for (int i=0; i<arr.length; i++){
            int sum=0;
            temp[i]=-1;
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j]==1) sum+= arr[i][j];
            }
            temp[i] =sum;
        }
        int max=0;
        int ans=0;
        for (int i=0; i<arr.length; i++) {
            if (temp[i]>max){
                max=temp[i];
                ans=i;
            }
        }
        return new int[]{ans,max};
    }
}