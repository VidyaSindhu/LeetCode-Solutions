class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] path: paths){
            int u = path[0]-1;
            int v = path[1]-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque();
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            queue.offer(i);
            visited[i] = true;
            
            res[i] = 1;
            while(!queue.isEmpty()){
                int node = queue.poll();
                
                for(int neighbor: adj[node]){
                    if(visited[neighbor]) continue;
                    visited[neighbor] = true;
                    
                    boolean[] color = new boolean[5];
                    for(int v: adj[neighbor]){
                        color[res[v]] = true;
                    }
                    for(int j = 1; j < 5; j++){
                        if(!color[j]){
                            res[neighbor] = j;
                            break;
                        }
                    }
                    queue.offer(neighbor);
                }
            }
        }
        
        return res;
    }
}