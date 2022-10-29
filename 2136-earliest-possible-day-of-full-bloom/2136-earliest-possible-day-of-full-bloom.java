class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        int[][] plants = new int[n][2];
        
        for(int i = 0; i < n; i++){
            plants[i][0] = plantTime[i];
            plants[i][1] = growTime[i];
        }
        
        Arrays.sort(plants, (a, b) -> b[1]-a[1]);
        
        int curr = 0, max = 0;
        for(int[] plant: plants){
            int time = curr + plant[0] + plant[1];
            max = Integer.max(time, max);
            curr += plant[0];
        }
        return max;
    }
}