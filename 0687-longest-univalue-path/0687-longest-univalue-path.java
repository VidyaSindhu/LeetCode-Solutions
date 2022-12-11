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
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root){
        if(root == null) return 0;
        
        int lenLeft = 0;
        if(root.left != null){
            if(root.val == root.left.val){
                lenLeft += 1 + dfs(root.left);
            }
            else{
                dfs(root.left);
            }
        }
        
        int lenRight = 0;
        if(root.right != null){
            if(root.val == root.right.val){
                lenRight += 1 + dfs(root.right);
            }
            else{
                dfs(root.right);
            }
        }
        ans = Integer.max(ans, lenLeft + lenRight);
        return Integer.max(lenLeft, lenRight);
    }
}