/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    // postorder: Left, Right, Root
    // inorder: Left, Root, Right
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        
        return helper(hashMap, 0, postorder.length - 1, 0, inorder.length, inorder, postorder);
    }
    
    private TreeNode helper(Map<Integer, Integer> map, int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inIndex = map.get(root.val);
        
        root.left = helper(map, postStart, postStart + (inIndex - inStart - 1), inStart, inIndex - 1, inorder, postorder);
        root.right = helper(map, postStart + (inIndex - inStart), postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        
        return root;
    }
}
