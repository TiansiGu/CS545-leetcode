/**
 * Leetcode 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC103 {
    /** Binary Tree, Breadth-First Search
     * Alternately add/poll at the head and tail of Deque
     * When add at head, poll from tail and put into result list;
     * When add at tail, poll from head and put into result list
     * Time: O(n), Space: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        boolean leftToRight = true;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addFirst(root);
        int idx = 0; //the index of the list of each level
        while (!dq.isEmpty()) {
            int size = dq.size();
            list.add(new ArrayList<>());
            if (leftToRight) { //print in list left to right
                for (int i = 0; i < size; i++) {
                    // poll from head, add at tail
                    TreeNode node = dq.pollFirst();
                    list.get(idx).add(node.val);
                    if (node.left != null) {
                        dq.addLast(node.left);
                    }
                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                }
            } else { //print in list right to left
                for (int i = 0; i < size; i++) {
                    // poll from tail, add at head
                    TreeNode node = dq.pollLast();
                    list.get(idx).add(node.val);
                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            idx++;
            leftToRight = !leftToRight; //next turn reverse the print order
        }
        return list;
    }
}
