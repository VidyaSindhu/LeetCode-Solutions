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
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Integer.max(ans[0], ans[1]);
    }
    // 0 -> withRoot, 1 -> withOutRoot
    int[] dfs(TreeNode root){
        if(root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int withRoot = left[1] + right[1] + root.val;
        int withOutRoot = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);
        
        return new int[]{withRoot, withOutRoot};
    }
}