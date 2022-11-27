class Solution {
    public int videoStitching(int[][] clips, int time) {
        int min = 0, max = 0;
        int count = 0;
        while(max < time){
            int localMax = max;
            for(int[] clip: clips){
                if(clip[0] <= max && max <= clip[1]){
                    localMax = Integer.max(localMax, clip[1]);
                }
            }
            
            if(localMax == max && max != time) return -1;
            max = localMax;
            count++;
        }
        
        return max == 0 ? -1 : count;
    }
}