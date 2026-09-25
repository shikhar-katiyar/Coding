class Solution {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        int n=nums.length;
        int pivot=p(nums);
        if (pivot==0) {
            return binary(nums, target, 0, n-1);
        }
        return Math.max(binary(nums, target, 0, pivot-1), binary(nums, target, pivot, n-1));
    }
    public int p(int[] nums) {
        int low=0;
        int high= nums.length-1;
        int a=0;
        while (low<high) {
            int mid=low+(high-low)/2;
            if (nums[mid]>nums[high]) {
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return low;
    }
    private int binary (int[] nums, int target, int low, int high) {
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid] < target) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}