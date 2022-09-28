class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] edge : prerequisites){
            adj[edge[1]].add(edge[0]);
        }
        
        int[] state = new int[adj.length];
        
        for(int i = 0; i < adj.length; i++){
            if(state[i] == 0){
                if(!dfs(adj, i, state)) return false;
            }
        }
        
        return true;
    }
    
    boolean dfs(List<Integer>[] adj, int node, int[] state){
        state[node] = 1;
        
        for(int neighbor : adj[node]){
            if(state[neighbor] == 1) return false;
            else if(state[neighbor] == 0){
                if(!dfs(adj, neighbor, state))
                    return false;
            }
        }
        state[node] = 2;
        return true;
    }
}