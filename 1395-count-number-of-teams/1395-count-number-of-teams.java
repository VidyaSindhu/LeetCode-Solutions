class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int n = rating.length;
        int leftSmaller = 0, rightSmaller = 0;
        int leftLarger = 0, rightLarger = 0;
        
        for(int i = 0; i < n; i++){
            leftSmaller = 0;
            rightSmaller = 0;
            leftLarger = 0;
            rightLarger = 0;
            for(int j = i+1; j < n; j++){
                if(rating[i] < rating[j]){
                    rightLarger++;
                }
                if(rating[i] > rating[j]){
                    rightSmaller++;
                }
            }
            
            for(int j = 0; j < i; j++){
                if(rating[i] < rating[j]){
                    leftLarger++;
                }
                if(rating[i] > rating[j]){
                    leftSmaller++;
                }
            }
            
            ans += leftLarger * rightSmaller + leftSmaller * rightLarger;
        }
        
        return ans;
    }
}