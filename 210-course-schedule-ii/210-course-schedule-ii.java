class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] edge : prerequisites){
            adj[edge[1]].add(edge[0]);
        }
        
        int[] state = new int[adj.length];
        Deque<Integer> stack = new ArrayDeque();
        
        for(int i = 0; i < adj.length; i++){
            if(state[i] == 0){
                if(dfs(adj, i, state, stack)) return new int[0];
            }
        }
        int[] topoSort = new int[stack.size()];
        
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            topoSort[i--] = stack.pop();
        }
        return topoSort;
    }
    
    boolean dfs(List<Integer>[] adj, int node, int[] state, Deque<Integer> stack){
        state[node] = 1;
        
        for(int neighbor : adj[node]){
            if(state[neighbor] == 1) return true;
            else if(state[neighbor] == 0){
                if(dfs(adj, neighbor, state, stack)){
                    return true;
                }
            }
        }
        
        stack.offer(node);
        state[node] = 2;
        return false;
    }
}