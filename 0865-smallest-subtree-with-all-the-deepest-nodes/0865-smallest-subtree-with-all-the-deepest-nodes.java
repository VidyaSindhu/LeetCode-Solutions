/**
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
    int maxDepth = -1;
    TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int l = helper(root.left, 1);
        int r = helper(root.right, 1);
        
        if(l == r && l >= maxDepth){
            maxDepth = l;
            res = root;
        }
        return res;
    }
    
    int helper(TreeNode root, int depth){
        if(root == null) return depth;
        int l = helper(root.left, depth+1);
        int r = helper(root.right, depth+1);
        
        if(l == r && l >= maxDepth){
            maxDepth = l;
            res = root;
        }
        
        return Integer.max(l, r);
    }
}