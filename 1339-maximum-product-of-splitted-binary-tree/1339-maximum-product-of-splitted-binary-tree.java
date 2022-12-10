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
    long ans = -1;
    int MOD = 1000000007;
    long totalSumTree = 0;
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        
        totalSumTree = sumTree(root);
        
        dfs(root);
        return (int)(ans % MOD);
    }
    
    long sumTree(TreeNode root){
        if(root == null) return 0;
        
        long sumLeft = sumTree(root.left);
        long sumRight = sumTree(root.right) + root.val;
        return sumLeft + sumRight;
    }
    
    long dfs(TreeNode root){
        if(root == null) return 0;
        
        long sumLeft = dfs(root.left);
        long sumRight = dfs(root.right);
        
        long tmp = totalSumTree - sumRight;
        tmp = tmp * sumRight;
        ans = Long.max(tmp, ans);
        
        tmp = totalSumTree - sumLeft;
        tmp = tmp * sumLeft;
        ans = Long.max(tmp, ans);
        
        return sumRight + sumLeft + root.val;
    }
}