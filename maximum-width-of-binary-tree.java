/**
 * Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maximumWidth = 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        // add root value
        queue.offer(new Pair<>(root, 0));
        
        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            
            Pair<TreeNode, Integer> firstNode = queue.peek();
            Pair<TreeNode, Integer> curr = null;
            
            while (currentQueueSize-- > 0) {
                curr = queue.poll();
                TreeNode node = curr.getKey();
                int position = curr.getValue();
                
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * position));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * position + 1));
                }
            }
            
            maximumWidth = Math.max(maximumWidth, curr.getValue() - firstNode.getValue() + 1);
        }
        
        return maximumWidth;
    }
}
