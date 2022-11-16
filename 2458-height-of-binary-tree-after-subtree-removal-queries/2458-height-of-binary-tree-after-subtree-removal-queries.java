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
    int maxHeight;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] preOrderHeight = new int[100001];
        int[] preOrderMirrorHeight = new int[100001];
        
        maxHeight = 0;
        preOrder(root, 0, preOrderHeight);
        
        maxHeight = 0;
        preOrderMirror(root, 0, preOrderMirrorHeight);
        
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            res[i] = Integer.max(preOrderHeight[queries[i]], preOrderMirrorHeight[queries[i]]);
        }
        
        return res;
    }
    
    void preOrder(TreeNode root, int h, int[] tree){
        if(root == null) return;
        tree[root.val] = maxHeight;
        maxHeight = Integer.max(maxHeight, h);
        preOrder(root.left, h + 1, tree);
        preOrder(root.right, h + 1, tree);
    }
    
    void preOrderMirror(TreeNode root, int h, int[] tree){
        if(root == null) return;
        tree[root.val] = maxHeight;
        maxHeight = Integer.max(maxHeight, h);
        preOrderMirror(root.right, h + 1, tree);
        preOrderMirror(root.left, h + 1, tree);
    }
}