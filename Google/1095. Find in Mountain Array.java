/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the peak using binary search
        int left = 0, right = n - 1;
        int peak = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                peak = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Step 2: Binary search on the left side (increasing part)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1)
            return index;

        // Step 3: Binary search on the right side (decreasing part)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    // Helper function to perform binary search
    private int binarySearch(MountainArray mountainArr, int target, 
                            int left, int right,boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (increasing) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
