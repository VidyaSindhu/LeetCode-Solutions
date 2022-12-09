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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
    
    void dfs(TreeNode root, int min, int max){
        if(root == null) return;
        ans = Integer.max(ans, Math.abs(min - root.val));
        ans = Integer.max(ans, Math.abs(max - root.val));
        dfs(root.left, Integer.min(root.val, min), Integer.max(root.val, max));
        dfs(root.right, Integer.min(root.val, min), Integer.max(root.val, max));
    }
}