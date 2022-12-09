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
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    void dfs(TreeNode root, StringBuilder sb){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sb.append(root.val);
            ans += Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
        
    }
}