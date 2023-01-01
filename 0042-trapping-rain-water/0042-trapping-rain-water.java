class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxLeft = height[0], maxRight = height[right];
        int ans = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(maxLeft - height[left] >= 0) ans += maxLeft - height[left];
                maxLeft = Integer.max(maxLeft, height[left]);
                left++;
            }
            else{
                if(maxRight - height[right] >= 0) ans += maxRight - height[right];
                maxRight = Integer.max(maxRight, height[right]);
                right--;
            }
        }
        
        return ans;
    }
}