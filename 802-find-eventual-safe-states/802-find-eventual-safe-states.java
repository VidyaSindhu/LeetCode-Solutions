class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        int n = graph.length;
        Deque<Integer> Stack = new ArrayDeque();
        int[] state = new int[n];
        boolean[] safe = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(state[i] == 0){
                if(!dfs(graph, i, state, safe)){
                    safe[i] = true;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(safe[i]){
                res.add(i);
            }
        }
        
        return res;
    }
    
    boolean dfs(int[][] graph, int node, int[] state, boolean[] safe){
        state[node] = 1;
        for(int neighbor: graph[node]){
            if(state[neighbor] == 1){
                return true;
            }
            else if(state[neighbor] == 0){
                boolean cycleExists = dfs(graph, neighbor, state, safe);
                if(!cycleExists){
                    safe[neighbor] = true;
                }
                else{
                    return true;
                }
            }
        }
        
        
        state[node] = 2;
        return false;
    }
}