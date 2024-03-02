/**
 * LC2. Add Two Numbers (LinkedList)
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class LC2 {
    /** Cannot just compute the two numbers and add them,
     because at most 100 digits, could cause leap
     Let m, n be the number of nodes in l1, l2
     Time: O(m + n), one pass iterating through l1, l2
     Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int place = 0; //remember if we need to "carried out" in the next turn
        while (p1 != null && p2 != null) {
            int num = p1.val + p2.val + place;
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            place = (num >= 10)? 1: 0;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int num = p1.val + place; //take p2's value as 0
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            place = (num >= 10)? 1: 0;
            p1 = p1.next;
        }
        while (p2 != null) {
            int num = p2.val + place; //take p1's value as 0
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            place = (num >= 10)? 1: 0;
            p2 = p2.next;
        }
        // handle the case that there exists excess value that needs to be "carried over"
        if (place == 1) cur.next = new ListNode(place);
        return dummy.next;
    }
}
