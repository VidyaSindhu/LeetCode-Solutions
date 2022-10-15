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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return construct(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    TreeNode construct(int[] inorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        if(postStart == postEnd) return root;
        
        int rootIndexPre = map.get(postorder[postEnd]);        
        
        int rightSubTreeStartPost = postEnd - (preEnd - rootIndexPre);
        
        root.left = construct(inorder, preStart, rootIndexPre-1, postorder, postStart, rightSubTreeStartPost-1);
        root.right = construct(inorder, rootIndexPre+1, preEnd, postorder, rightSubTreeStartPost, postEnd-1);
        
        return root;
    }
}