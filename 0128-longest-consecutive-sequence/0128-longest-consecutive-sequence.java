class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        
        int best = 0;
        for(int x : nums){
            if(!set.contains(x-1)){
                int y = x + 1;
                while(set.contains(y)){
                    y++;
                }
                best = Integer.max(best, y-x);
            }
        }
        
        return best;
    }
}