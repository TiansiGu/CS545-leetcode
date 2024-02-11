import java.util.ArrayList;
import java.util.List;

/** Definition for singly-linked list *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


/** Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC109 {
    // Solution func
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // convert linked list to array list, get O(1) retrieve time
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode result = traversal(list, 0, list.size()-1);
        return result;
    }

    // Helper func
    private TreeNode traversal(List<Integer> list, int left, int right) {
        // base case
        if (left > right) return null;
        if (left == right) return new TreeNode(list.get(left));
        // recursive class
        int mid = left + (right - left) / 2;
        // list is sorted, so elements to the left of mid is smaller than mid,
        // elements to the right of mid is larger than mid
        // so recursively construct the tree fulfills the condition of BST
        TreeNode node = new TreeNode(list.get(mid));
        node.left = traversal(list, left, mid-1);
        node.right = traversal(list, mid+1, right);
        return node;
    }
}
