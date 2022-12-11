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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans = Integer.max(ans, Integer.max(leftSum, 0) + Integer.max(rightSum, 0) + root.val);
        
        return Integer.max(Integer.max(leftSum, rightSum), 0) + root.val;
    }
}
