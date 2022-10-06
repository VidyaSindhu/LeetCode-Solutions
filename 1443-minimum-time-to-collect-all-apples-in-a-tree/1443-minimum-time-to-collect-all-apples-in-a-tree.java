class Solution {
    int ans = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int ans = dfs(adj, 0, visited, hasApple);
        
        return ans;
    }
    
    int dfs(List<Integer>[] adj, int node, boolean[] visited, List<Boolean> hasApple){
        visited[node] = true;
        
        int time = 0;
        for(int neighbor: adj[node]){
            if(!visited[neighbor]){
                time += dfs(adj, neighbor, visited, hasApple);
            }
        }
        
        // if any of the descendents (including itself) of this node has apple then we have to add 2
        // 1 for going from this node and 1 for coming to this node;
        // EXCEPT for 0
        if((time > 0 || hasApple.get(node)) && node != 0) time += 2;
        return time;
    }
}