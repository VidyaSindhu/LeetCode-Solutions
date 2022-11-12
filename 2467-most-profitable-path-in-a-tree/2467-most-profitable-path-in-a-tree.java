class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Deque<int[]> q = new ArrayDeque();
        
        int[] nAmount = new int[n];
        for(int i = 0; i < n; i++) nAmount[i] = amount[i];
        
        int[] stepCount = new int[n];
        Arrays.fill(stepCount, -1);
        stepCount[bob] = 0;
        
        int[] pred = new int[n];
        Arrays.fill(pred, -1);
        
        bfs(adj, bob, pred);
        
        List<Integer> path = new ArrayList<Integer>();
        int crawl = 0;
        amount[crawl] = 0;
        
        path.add(crawl);
        int s = 0;
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            s++;
            amount[pred[crawl]] = 0;
            crawl = pred[crawl];
        }
        
        
        for(int i : path){
            stepCount[i] = s--;
        }
    
        boolean[] visited = new boolean[n];
        q.offer(new int[]{0, 0, nAmount[0]});
        visited[0] = true;
        
        int ans = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int[] top = q.poll();
            int node = top[0];
            int steps = top[1];
            int cost = top[2];
            steps++;
            
            boolean found = false;
            for(int neighbor: adj[node]){
                if(visited[neighbor]) continue; 
                
                if(stepCount[neighbor] == steps){
                    q.offer(new int[]{neighbor, steps, cost + nAmount[neighbor]/2});
                }
                else if(stepCount[neighbor] != -1){
                    if(stepCount[neighbor] < steps){
                        q.offer(new int[]{neighbor, steps, cost});    
                    }
                    else{
                        q.offer(new int[]{neighbor, steps, cost + nAmount[neighbor]});    
                    }
                    
                }
                else{
                    q.offer(new int[]{neighbor, steps, cost + nAmount[neighbor]});
                }
                found = true;
                visited[neighbor] = true;
            }
            
            if(!found){
                ans = Integer.max(ans, cost);
            }
        }
        
        
        return ans;
    }
    
    void bfs(List<Integer>[] adj, int src, int pred[]){
        Deque<Integer> queue = new ArrayDeque();
        boolean visited[] = new boolean[adj.length];
 
        visited[src] = true;
        queue.offer(src);
 
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i: adj[u]) {
                if (!visited[i]) {
                    visited[i] = true;
                    pred[i] = u;
                    queue.add(i);
                    if (i == 0)
                        return;
                }
            }
        }
    }
}