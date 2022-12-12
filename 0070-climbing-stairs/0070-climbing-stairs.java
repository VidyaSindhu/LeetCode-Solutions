class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int first = 0, second = 1, third = 2;
        for(int i = 3; i < n+1; i++){
            first = third + second;
            second = third;
            third = first;
        }
        
        return third;
    }
}