/**
 * Leetcode 147.Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/description/
 */

/**
 * Definition for singly-linked list
  */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/** Insertion sort + linked List
 Time: O(n^2)
 Space: O(1)
 */
public class ExtraCredit1_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(); //don‘t initialize dummy with next can create an end for the sorted list
        ListNode curr = head;
        // outer loop, keep the start of unsorted list
        while (curr != null) {
            // keep record of the pre node of the position should be inserted
            ListNode prev = dummy;
            // find the position to insert the current node
            // due to single linked list: find from front to end
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            ListNode next = curr.next;
            // insert the current node to the sorted list
            curr.next = prev.next;
            prev.next = curr;
            // moving on to the next iteration
            curr = next;
        }

        return dummy.next;
    }
}