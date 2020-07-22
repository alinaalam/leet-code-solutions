/**
 * Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> leftToRight = new Stack<>();
        Stack<TreeNode> rightToLeft = new Stack<>();
        
        leftToRight.push(root);
        List<Integer> currentLevel;
        
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            currentLevel = new LinkedList<>();
            
            while(!leftToRight.isEmpty()) {
                TreeNode current = leftToRight.pop();
                currentLevel.add(current.val);
                
                if (current.left != null) {
                    rightToLeft.push(current.left);
                }
                
                if (current.right != null) {
                    rightToLeft.push(current.right);
                }
            }
        
            if (!currentLevel.isEmpty()) {
                list.add(currentLevel);
            }
            
            currentLevel = new LinkedList<>();
        
            while(!rightToLeft.isEmpty()) {
                    TreeNode current = rightToLeft.pop();
                    currentLevel.add(current.val);

                    if (current.right != null) {
                        leftToRight.push(current.right);
                    }

                    if (current.left != null) {
                        leftToRight.push(current.left);
                    }
            }

            if (!currentLevel.isEmpty()) {
                list.add(currentLevel);
            }
        }
        
        return list;
    }
}
