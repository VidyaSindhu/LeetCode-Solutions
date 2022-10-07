class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++) adj[i] = new ArrayList();
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        PriorityQueue<Integer> valIdx = new PriorityQueue<>((a, b) -> vals[a]-vals[b]);
        for(int i = 0; i < n; i++){
            valIdx.offer(i);
        }
        
        int[] lastCount = new int[n];
        Arrays.fill(lastCount, 1);
        
        int[] lastNum = new int[n];
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            lastNum[i] = vals[i];
        }
        
        int ans = 0;
        while(!valIdx.isEmpty()){
            int node = valIdx.poll();
            
            for(int neighbor: adj[node]){
                if(vals[neighbor] > vals[node]) continue;
                int p1 = find(parents, node);
                int p2 = find(parents, neighbor);
                
                if(p1 == p2) continue;
                
                if(lastNum[p1] == lastNum[p2]){
                    ans += lastCount[p1] * lastCount[p2];
                    lastCount[p1] += lastCount[p2];
                }
                parents[p2] = p1;
                lastNum[p1] = vals[node];
            }
        }
        return ans + n;
    }
    
    int find(int[] parents, int i){
        if(parents[i] == i) return i;
        return parents[i] = find(parents, parents[i]);
    }
}