class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean found = false;
        for(String s: bank){
            if(s.equals(endGene)) found = true;
        }
        
        if(!found || bank.length == 0) return -1;
        Deque<Pair<String, Integer>> queue = new ArrayDeque();
        queue.add(new Pair(startGene, 0));
        
        Set<String> visited = new HashSet();
        while(!queue.isEmpty()){
            Pair<String, Integer> top = queue.poll();
            if(stringDiff(top.getKey(), endGene) == 1) return top.getValue()+1;
            
            for(String s: bank){
                if(stringDiff(top.getKey(), s) == 1 && !visited.contains(s)){
                    queue.add(new Pair(s, top.getValue()+1));
                    visited.add(s);
                }
            }
        }
        
        return -1;
    }
    
    int stringDiff(String a, String b){
        int i = 0;
        int count = 0;
        while(i < a.length()){
            if(a.charAt(i) != b.charAt(i)) count++;
            i++;
        }
        return count;
    }
}