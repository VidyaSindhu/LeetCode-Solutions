class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int n = rating.length;
        int[] smallerRatingLeft = new int[n];
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(rating[i] < rating[j]){
                    smallerRatingLeft[i]++;
                }
            }
        }
        
        int[] smallerRatingRight = new int[n];
        for(int i = n-1; i >= 1; i--){
            for(int j = i-1; j >= 0; j--){
                if(rating[i] < rating[j]){
                    smallerRatingRight[i]++;
                }
            }
        }
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(rating[i] < rating[j]){
                    ans += smallerRatingLeft[j];
                }
            }
        }
        
        for(int i = n-1; i >= 1; i--){
            for(int j = i-1; j >= 0; j--){
                if(rating[i] < rating[j]){
                    ans += smallerRatingRight[j];
                }
            }
        }
        
        return ans;
    }
}