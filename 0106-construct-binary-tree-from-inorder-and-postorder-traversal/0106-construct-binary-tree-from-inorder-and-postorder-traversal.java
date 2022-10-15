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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    TreeNode construct(int[] inorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        if(postStart == postEnd) return root;
        
        int rootIndexPre = -1;
        for(int i = preStart; i <= preEnd; i++){
            if(inorder[i] == postorder[postEnd]){
                rootIndexPre = i;
                break;
            }
        }
        
        
        int rightSubTreeStartPost = postEnd - (preEnd - rootIndexPre);
        
        root.left = construct(inorder, preStart, rootIndexPre-1, postorder, postStart, rightSubTreeStartPost-1);
        root.right = construct(inorder, rootIndexPre+1, preEnd, postorder, rightSubTreeStartPost, postEnd-1);
        
        return root;
    }
}