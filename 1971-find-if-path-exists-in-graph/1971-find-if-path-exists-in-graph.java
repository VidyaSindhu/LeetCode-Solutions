class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        Deque<Integer> queue = new ArrayDeque();
        queue.offer(source);
        
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(u == destination) return true;
            
            for(int v: adj[u]){
                if(visited[v]) continue;
                
                queue.offer(v);
                visited[v] = true;
            }
        }
        
        return false;
    }
}