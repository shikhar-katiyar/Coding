class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1=0, n2=0;
        int i=0, j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]==nums2[j]) {
                n1++;
                i++;
            }
            else if (nums1[i]<nums2[j]) i++;
            else j++;
        }
        i=0;
        j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]==nums2[j]) {
                n2++;
                j++;
            }
            else if (nums1[i]>nums2[j]) j++;
            else i++;
        }
        return new int[]{n1, n2};
    }
}