class Solution {
    Set<Integer> set;
    int lastPos;
    Map<Pair<Integer, Integer>, Boolean> dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        set = new HashSet();
        for(int stone: stones) set.add(stone);
        
        dp = new HashMap();
        
        lastPos = stones[n-1];
        if(stones[1] - stones[0] != 1) return false;
        return helper(stones[1], 1);
    }
    
    boolean helper(int pos, int jump){
        if(pos > lastPos) return false;
        if(lastPos == pos) return true;
        
        boolean ans = false;
        Pair<Integer, Integer> pair = new Pair(pos, jump);
        if(dp.containsKey(pair)) return dp.get(pair);
        
        if(set.contains(pos + jump + 1)){
            ans |= helper(pos + jump + 1, jump + 1);
            
            if(ans) {
                dp.put(pair, true);
                return true;
            }
        }
        
        if(set.contains(pos + jump)){
            ans |= helper(pos + jump, jump);
            if(ans) {
                dp.put(pair, true);
                return true;
            }
        }
        
        if(jump > 1 && set.contains(pos + jump - 1)){
            ans |= helper(pos + jump - 1, jump - 1);
            if(ans) {
                dp.put(pair, true);
                return true;
            }
        }
        
        dp.put(pair, false);
        return false;
    }
}