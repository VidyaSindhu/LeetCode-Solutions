class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        bfs(rooms, visited);
        // dfs(rooms, 0, visited);
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 0) return false;
        }
        
        return true;
    }
    
    void dfs(List<List<Integer>> graph, int u, int visited[]){
        visited[u] = 1;
        for(int v : graph.get(u)){
            if(visited[v] == 0){
                dfs(graph, v, visited);
            }
        }
    }
    
    void bfs(List<List<Integer>> graph, int[] visited){
        Deque<Integer> queue = new ArrayDeque();
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            visited[u] = 1;
            for(int v : graph.get(u)){
                if(visited[v] == 0){
                    queue.offer(v);
                }
            }
        }
    }
}