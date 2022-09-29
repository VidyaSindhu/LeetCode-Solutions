class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int edge[] : richer){
            adj[edge[1]].add(edge[0]);
        }
        
        int[] state = new int[n];
        
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0; i < n; i++){
            if(state[i] == 0){
                dfs(adj, i, quiet, res);
            }
        }
        
        return res;
    }
    
    
    int dfs(List<Integer>[] adj, int node, int[] quiet, int[] res){
        if(res[node] == -1){
            res[node] = node;
            for(int neighbor : adj[node]){
                int cand = dfs(adj, neighbor, quiet, res);
                if(quiet[res[node]] > quiet[cand]){
                    res[node] = cand;
                }
            }
        }
        return res[node];
    }
}