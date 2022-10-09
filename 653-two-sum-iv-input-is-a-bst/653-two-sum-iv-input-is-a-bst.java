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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        return dfs(root, root, k);
    }
    
    boolean dfs(TreeNode root, TreeNode curr, int k){
        if(curr == null) return false;
        
        if(search(root, k-curr.val, curr)) return true;
        
        return dfs(root, curr.left, k) || dfs(root, curr.right, k);
    }
    
    boolean search(TreeNode root, int target, TreeNode taken){
        if(root == null) return false;
        if(target == root.val && taken != root) return true;
        
        if(target < root.val) return search(root.left, target, taken);
        return search(root.right, target, taken);
    }
}