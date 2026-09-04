class Solution {
    public int maxProduct(int[] nums) {
        int m1=0;
        for (int i=0; i<nums.length; i++){
            if (nums[m1]<nums[i]) m1=i;
        }
         int m2 = (m1 == 0) ? 1 : 0; 
        for (int i=0; i<nums.length; i++){
            if (nums[m2]<nums[i] && i!=m1) m2=i;
        }
        int r= (nums[m1]-1)*(nums[m2]-1);
        return r;
    }
}