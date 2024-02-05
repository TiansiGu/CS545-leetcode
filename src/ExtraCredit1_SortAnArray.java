public class ExtraCredit1_SortAnArray {
    /** Quick Sort
     * partition the array such that the left part elements are smaller than the pivot
     * and the right part elements are larger than the pivot
     * Do the partition recursively until there are <= 1 elements on both side
     * Time: O(n^2) in the worst case; O(n * log n) in the best case
     * Space: O(n) in the worst case, stack expenses in recursion
     * */
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        //let the right most element to be pivot (partition)
        int pivot = nums[right];
        int i = left;
        int temp;
        for (int j = left; j <= right - 1; j++) {
            // When an element at right is smaller than pivot, put it on the left side by swap
            if (nums[j] < pivot) {
                //swap element at index i and j
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        //swap the pivot to be the partition
        temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        //return the index of partition
        return i;
    }
}
