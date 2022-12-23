class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
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
        
        int[] childs = new int[n];
        int[] sumDis = new int[n];
        dfs(adj, 0, -1, childs, 0, sumDis);
        
        // for(int num: childs) System.out.print(num + " ");
        
        for(int v : adj[0]){
            calTotalDis(adj, v, 0, childs, sumDis);
        }
        
        return sumDis;
    }    
    
    void dfs(List<Integer>[] adj, int node, int parent, int[] childs, int depth, int[] sumDis){
        sumDis[0] += depth;
        for(int v: adj[node]){
            if(parent == v) continue;
            dfs(adj, v, node, childs, depth + 1, sumDis);
            childs[node] += childs[v];
        }
        childs[node]++;
    }
    
    void calTotalDis(List<Integer>[] adj, int node, int parent, int[] childs, int[] sumDis){
        sumDis[node] = sumDis[parent] - childs[node] + (childs.length - childs[node]);
        for(int v: adj[node]){
            if(parent == v) continue;
            calTotalDis(adj, v, node, childs, sumDis);
        }
    }
}