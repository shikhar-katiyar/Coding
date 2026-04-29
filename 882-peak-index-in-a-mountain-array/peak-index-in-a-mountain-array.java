class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return search(0, arr.length - 1, arr);
    }

    private static int search(int low, int high, int[] arr) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                return search(mid + 1, high, arr);
            } else {
                return search(low, mid, arr);
            }
        }
        return low;
    }
}
