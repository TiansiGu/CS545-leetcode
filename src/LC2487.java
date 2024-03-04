import java.util.Stack;

/**
 * 2487. Remove Nodes From Linked List (LinkedList)
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 */
public class LC2487 {
    /**
     * traverse in reverse order, keep track of the maxmium value, whatever met a node that is
     * smaller than the maxmimum value, remove it
     * Time: O(N), Space: O(N). Suppose there are N nodes in input
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> sdk = new Stack<>();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy; //dummy head, avoid edge case separation
        while (cur != null) {
            sdk.push(cur);
            cur = cur.next;
        }
        cur = sdk.pop();
        int maxVal = cur.val;
        ListNode pre;
        while (sdk.size() > 1) {
            cur = sdk.pop();
            pre = sdk.peek();
            if (cur.val < maxVal) {
                pre.next = cur.next;
            }
            maxVal = Math.max(maxVal, cur.val);
        }
        return dummy.next;
    }
}
