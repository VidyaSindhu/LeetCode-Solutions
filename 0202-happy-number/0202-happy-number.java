class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        
        int sum = getSquaresDigits(n);
        if(sum == 1) return true;
        while(!set.contains(sum)){
            set.add(sum);
            sum = getSquaresDigits(sum);
            if(sum == 1) return true;
        }
        
        return false;
    }
    
    int getSquaresDigits(int n){
        int ans = 0;
        while(n != 0){
            int lastDigit = (int)(n % 10);
            ans += lastDigit * lastDigit;
            n /= 10;
        }
        
        return ans;
    }
}