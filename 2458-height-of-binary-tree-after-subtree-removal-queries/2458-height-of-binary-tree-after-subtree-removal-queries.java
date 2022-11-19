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
    int N = 100001;
    int time = 1;
    int[] start;
    int[] end;
    int[] tree;
    int n = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        start = new int[N];
        end = new int[N];
        tree = new int[2 * N + 1];
        
        dfs(root, 0);
        
        int[] prefixMax = new int[2 * N + 1];
        for(int i = 1; i < tree.length; i++){
            prefixMax[i] = Integer.max(prefixMax[i-1], tree[i]);
        }
        
        int[] suffixMax = new int[tree.length];
        suffixMax[suffixMax.length-1] = tree[tree.length-1];
        for(int i = tree.length-2; i >= 0; i--){
            suffixMax[i] = Integer.max(suffixMax[i+1], tree[i]);
        }
        
        int[] res = new int[queries.length];
        for(int i = 0; i < res.length; i++){
            res[i] = Integer.max(prefixMax[start[queries[i]]-1], suffixMax[end[queries[i]] + 1]);
        }
        
        return res;
    }
    
    void dfs(TreeNode root, int depth){
        if(root == null) return;
        start[root.val] = time;
        tree[time++] = depth;
        n++;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        
        end[root.val] = time;
        tree[time++] = depth;
    }
}