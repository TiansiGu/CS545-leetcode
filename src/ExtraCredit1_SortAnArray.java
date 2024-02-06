/**
 * Leetcode 912. Sort an Array
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class ExtraCredit1_SortAnArray {
    /** Shell Sort
     * Partially sort array using different gap
     * gap start from length/2, reduce the gap by half in every iteration
     * all the way down to 1 (when it is insertion sort, but now we have a partially sorted array)
     * reduce the number of shift
     * Time: O(n^2), Space: O(1)
     * */
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap >= 1; gap/=2) {
            for (int i = gap; i < len; i++) {
                int curr = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > curr) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = curr;
            }
        }
        return nums;
    }
}
