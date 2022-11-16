class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        
        int low = arr[0], high = arr[n-1];
        
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i <= high; i++){
            int ceil = ceil(arr, i);
            int leftSum = ceil == 0 ? 0 : prefix[ceil-1];
            int rightSum = i * (n - ceil);
            if(Math.abs(target - leftSum - rightSum) < diff){
                diff = Math.abs(target - leftSum - rightSum);
                ans = i;
            }
            else if(Math.abs(target - leftSum - rightSum) == diff){
                ans = Integer.min(i, ans);
                // System.out.println(diff + "  " + i);
            }
        }

        return ans;
    }

    int ceil(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }
}