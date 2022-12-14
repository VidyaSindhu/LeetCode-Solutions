class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        
        int[] maxValueMinusI = new int[n];
        maxValueMinusI[n-1] = values[n-1] - (n-1);
        
        for(int i = 1; i < n; i++){
            maxValueMinusI[n-i-1] = Integer.max(maxValueMinusI[n-i], values[n-i-1] - (n-i-1));
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++){
            ans = Integer.max(values[i] + i + maxValueMinusI[i+1], ans);
        }
        return ans;
    }
}