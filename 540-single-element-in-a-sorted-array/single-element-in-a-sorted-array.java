class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0, high=nums.length-1, ans=-1;
        while(low<=high) {
            int mid= low+(high-low)/2;
            int a=-1;
            if (mid > 0 && nums[mid]==nums[mid-1]) a=mid-1;
            else if (mid < nums.length - 1 && nums[mid]==nums[mid+1]) a=mid;
            if (a == -1) return nums[mid];
            if (a%2==1){
                ans=mid;
                high=mid-1;
            }
            else{
                ans=mid;
                low=mid+1;
            }
        }
        return nums[ans];
    }
}