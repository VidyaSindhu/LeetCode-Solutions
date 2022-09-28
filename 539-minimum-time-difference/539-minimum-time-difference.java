class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList();
        
        for(String t : timePoints){
            time.add(getTimeInMinutes(t));
        }
        Collections.sort(time);
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < time.size(); i++){
            ans = Integer.min(ans, getTimeDiff(time.get(i-1), time.get(i)));
            
            ans = Integer.min(ans, getTimeDiff(time.get(0), time.get(i)));
        }
        
        return ans;
    }
    
    int getTimeDiff(int t1, int t2){
        int diff = t2-t1;
        if(diff > 12 * 60) return 24 * 60 - diff;
        return diff;
    }
    
    int getTimeInMinutes(String t){
        int hour = Integer.parseInt(t.substring(0, 2));
        int min = Integer.parseInt(t.substring(3, 5));
        return 60 * hour + min;
    }
}