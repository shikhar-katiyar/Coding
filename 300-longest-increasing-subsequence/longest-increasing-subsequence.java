import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (temp.size() == 0 || nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int low=0;
                int high = temp.size()-1;
                while (low<=high) {
                    int mid=(low+high)/2;
                    if (temp.get(mid)>= nums[i]) {
                        high=mid-1;
                    }
                    else low=mid+1;
                }
                temp.set(low, nums[i]);
            }
        }

        return temp.size();
    }
}