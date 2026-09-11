class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr= new int[nums.length][2];
        for (int k=0; k<nums.length;k++){
            arr[k][0]= nums[k];
            arr[k][1]=k;
        }
        java.util.Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            if (arr[i][0] + arr[j][0] == target) return new int[]{arr[i][1], arr[j][1]};
            else if (arr[i][0]+arr[j][0]>target) j--;
            else i++;
        }
        return new int[]{};
    }
}