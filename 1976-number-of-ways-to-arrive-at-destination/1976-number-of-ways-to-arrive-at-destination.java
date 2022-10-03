class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        List<int[]>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int cost = road[2];
            adj[u].add(new int[]{v, cost});
            adj[v].add(new int[]{u, cost});
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[0] = 0;
        
        int[] count = new int[n];
        count[0] = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int cost = pq.peek()[1];
            pq.poll();
            
            for(int[] neighbor: adj[node]){
                if(cost + neighbor[1] < dis[neighbor[0]]){
                    count[neighbor[0]] = count[node] % MOD;
                    dis[neighbor[0]] = cost + neighbor[1];
                    pq.offer(new int[]{neighbor[0], dis[neighbor[0]]});
                }
                else if(cost + neighbor[1] == dis[neighbor[0]]){
                    count[neighbor[0]] += count[node];
                    count[neighbor[0]] %= MOD;
                }
            }
        }
        
        return count[n-1];
    }
}