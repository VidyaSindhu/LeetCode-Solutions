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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1){
            TreeNode dummy = new TreeNode(val, root, null);
            return dummy;
        }
        else if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        
        addOneRow(root.left, val, depth-1);
        addOneRow(root.right, val, depth-1);
        
        return root;
    }
    
//     void addOneRow(TreeNode root, int val, int depth){
//         if(depth == 2){
//             root.left = new TreeNode(val, root.left, null);
//             root.right = new TreeNode(val, root.right, null);
//             return;
//         }
        
//         addOneRow(root.left, val, depth-1)
//     }
}