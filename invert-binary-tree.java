/**
 * Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
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
    
    // approach 1: recursive solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } 
        
        TreeNode temp = root.right;
        
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        
        return root;
    }
    
    // approach 2: iterative solution
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         } 
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
        
//         while (!queue.isEmpty()) {
//             TreeNode currentNode = queue.poll();
            
//             TreeNode temp = currentNode.left;
//             currentNode.left = currentNode.right;
//             currentNode.right = temp;
            
//             if (currentNode.left != null)
//                 queue.offer(currentNode.left);
//             if (currentNode.right != null)
//                 queue.offer(currentNode.right);
//         }
        
//         return root;
//     }
}
