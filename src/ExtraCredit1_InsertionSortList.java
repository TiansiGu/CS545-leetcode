/**
 * Leetcode 147.Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/description/
 */

/** Insertion sort + linked List
 Time: O(n^2)
 Space: O(1)
 */
public class ExtraCredit1_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(); //don‘t initialize dummy with next can create an end for the sorted list
        ListNode cur = head;
        // outer loop, keep the start of unsorted list
        while (cur != null) {
            // keep record of the pre node of the position to be inserted
            ListNode pre = dummy;
            ListNode p2 = dummy.next;
            // find insertion position
            // due to single linked list: find from front to end
            while (p2 != null && p2.val <= cur.val) {
                pre = p2;
                p2 = p2.next;
            }
            // Insertion
            // keep curr.next to access it in the future
            ListNode next = cur.next;
            // insert the current node by editing next pointers
            cur.next = p2;
            pre.next = cur;
            // go to the next node
            cur = next;
        }

        return dummy.next;
    }
}