class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int low = 0, high = stones[n-1] - stones[0];
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(stones, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    boolean isPossible(int[] stones, int jump){
        int n = stones.length;
        boolean[] visited = new boolean[n];
        
        int curr = 0;

        for(int i = 0; i < stones.length-1; i++){
            curr = i + 1;
            while(curr < stones.length && stones[curr] - stones[i] <= jump){
                curr++;
            }
            if(i == curr-1) return false;
            if(curr == stones.length) break;
            visited[curr-1] = true;
            i = curr-2;
        }
        
        int start = stones.length - 1;
        int prev = start;
        for(int i = stones.length-2; i >= 0;){
            if(visited[i]){
                i--;
                continue;
            }
            if(stones[start] - stones[i] > jump) {
                if(start == prev) return false;
                start = prev;
            }
            else{
                prev = i;
                i--;
            }
        }
        return true;
    }
}