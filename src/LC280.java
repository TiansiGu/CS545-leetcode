/**
 * Leetcode 280. Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort/description/
 */
public class LC280 {
    /** Sorting
     * variation of bubble sort
     * Time: O(n^2), Space: O(1)
     */
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        // each pass of outer for loop, put two elements in the correct position
        for (int i = 0; i < len-1; i+=2) {
            //bubble the smallest element to top
            for (int j = len-1; j > i; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j - 1, j);
            }
            //bubble the largest element to top
            for (int j = len-1; j > i+1; j--) {
                if (nums[j] > nums[j - 1]) swap(nums, j - 1, j);
            }
        }
    }

    // Helper function
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
