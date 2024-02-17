public class LC75 {
    /**
     * Method1: Quicksort partition
     * First partition 0 and other numbers
     * Then partition 1 and 2
     * Time: O(n), Space: O(1)  (n is the number of elements in nums arr)
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1;
        // partition 0 and non zero
        while (i <= j) {
            while (i <= j && nums[i] == 0) {
                i++;
            }
            while (i <= j && nums[j] != 0) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        //Now i is in the position that all of the elements to the right of it is 0
        //If nums has no 1/2, i out of index, return
        if (i >= len) return;
        j = len - 1; //put j back to the right border of nums
        // partition 1 and 2
        while (i <= j) {
            while (i <= j && nums[i] == 1) {
                i++;
            }
            while (i <= j && nums[j] != 1) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
    }

    /**
     * Follow-up: one pass solution
     * three pointers
     * Time: O(n), Space: O(1)
     */
    public void sortColors2(int[] nums) {
        int len = nums.length;
        // p0 is the rightmost boundary of 0, nums[idx < p0] = 0
        // p2 is the leftmost boundary of 0, nums[idx > p2] = 1
        int p0 = 0, p2 = len - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0, cur);
                //Why cur++? the element swapped from the front must be 0 or 1;
                //no cur++ would cause dead loop
                cur++;
                p0++;
            }
            else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                //Why not cur++ here？the element swapped from the back can be 2,
                //If cur++, 2 will be left in the middle
                p2--;
            }
            else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
