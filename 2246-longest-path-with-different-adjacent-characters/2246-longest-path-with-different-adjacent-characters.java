class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap();
        int n = parent.length;
        for(int i = 0; i < n; i++){
            adj.putIfAbsent(parent[i], new ArrayList());
            adj.get(parent[i]).add(i);
        }
        
        dfs(adj, -1, s);
        return ans;        
    }
    
    int dfs(Map<Integer, List<Integer>> adj, int node, String s){
        if(adj.get(node) == null || adj.get(node).isEmpty()) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int child: adj.get(node)){
            if(node != -1 && s.charAt(child) != s.charAt(node)){
                pq.offer(1 + dfs(adj, child, s));
            }
            else{
                dfs(adj, child, s);
            }
        }

        
        int size = Integer.min(pq.size(), 2);
        int len = 0;
        Integer first = 0;
        while(size --> 0){
            if(first == 0){
                first = pq.poll();
                len += first;
            }
            else len += pq.poll();
        }
        ans = Integer.max(ans, len + 1);
        return first;
    }
}