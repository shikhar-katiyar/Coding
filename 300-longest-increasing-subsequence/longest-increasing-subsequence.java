import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (temp.size() == 0 || nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int p = 0;
                while (temp.get(p) < nums[i]) {
                    p++;
                }
                temp.set(p, nums[i]);
            }
        }

        return temp.size();
    }
}