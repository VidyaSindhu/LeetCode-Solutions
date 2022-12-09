class Solution {
    void constructGraph(int[][] edges, List<Integer>[] adj){
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList();
        }
        for(int[] edge: edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            adj[u].add(v);
            adj[v].add(u);
        }
    }
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        constructGraph(edges, adj);
        
        Deque<int[]> queue = new ArrayDeque();
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        
        Map<Integer, Integer> components = new HashMap();
        for(int i = 0; i < n; i++){
            Arrays.fill(distances, -1);
            queue.offer(new int[]{i, i});
            
            distances[i] = 0;
            int steps = 0;
            int minIdx = i;
            while(!queue.isEmpty()){
                int size = queue.size();
                steps++;
                while(size --> 0){
                    int[] top = queue.poll();
                    int node = top[0];
                    int parent = top[1];

                    for(int v : adj[node]){
                        if(v == parent) continue;
                        if(distances[v] == -1){
                            distances[v] = steps;
                            minIdx = Integer.min(minIdx, v);
                            queue.offer(new int[]{v, node});
                        }
                        else if((steps-distances[v]) % 2 == 1) {
                            return -1;
                        }
                    }
                }
            }
            components.put(minIdx, Integer.max(components.getOrDefault(minIdx, 0), steps));
        }
        int ans = 0;
        for(int value: components.values()){
            ans += value;
        }
        
        return ans;
    }
}