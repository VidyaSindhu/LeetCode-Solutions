class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap();
        int n = parent.length;
        for(int i = 0; i < n; i++){
            adj.putIfAbsent(parent[i], new ArrayList());
            adj.get(parent[i]).add(i);
        }
        // System.out.println(adj);
        // ans = Integer.max(ans, );
        dfs(adj, -1, s);
        return ans;        
    }
    
    int dfs(Map<Integer, List<Integer>> adj, int node, String s){
        if(adj.get(node) == null || adj.get(node).isEmpty()) return 0;
        
        int lenLeft = 0, lenRight = 0;
        List<Integer> list = new ArrayList();
        for(int child: adj.get(node)){
            if(node != -1 && s.charAt(child) != s.charAt(node)){
                list.add(1 + dfs(adj, child, s));
            }
            else{
                dfs(adj, child, s);
            }
        }
//         if(adj.get(node).size() > 0){
//             int child = adj.get(node).get(0);
            
//         }
        
//         if(adj.get(node).size() > 1){
//             int child = adj.get(node).get(1);
//             if(node != -1 && s.charAt(child) != s.charAt(node)){
//                 lenRight += 1 + dfs(adj, child, s);
//             }
//             else{
//                 dfs(adj, child, s);
//             }
//         }
//         System.out.println(node + " " + lenLeft + " " + lenRight);
        Collections.sort(list, (a, b) -> b-a);
        // ans = Integer.max(ans, lenLeft + lenRight + 1);
        int size = Integer.min(list.size(), 2);
        int len = 0;
        int i = 0;
        while(size --> 0){
            len += list.get(i++);
        }
        ans = Integer.max(ans, len + 1);
        return list.isEmpty() ? 0 : list.get(0);
    }
}