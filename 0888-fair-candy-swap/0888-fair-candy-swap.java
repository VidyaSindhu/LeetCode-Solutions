class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        
        int aliceSum = 0;
        for(int num: aliceSizes){
            aliceSum += num;
        }
        
        int bobSum = 0;
        for(int num: bobSizes){
            bobSum += num;
        }
        int sum = (aliceSum + bobSum)/2;
        int[] res = new int[2];
        
        if(sum - aliceSum > 0){
            for(int i = 0; i < aliceSizes.length; i++){
                int target = sum - aliceSum + aliceSizes[i];
                int low = 0, high = bobSizes.length-1;
                while(low <= high){
                    int mid = low + (high - low)/2;
                    if(bobSizes[mid] == target){
                        return new int[]{aliceSizes[i], bobSizes[mid]};
                    }
                    else if(bobSizes[mid] < target) low = mid + 1;
                    else high = mid - 1;
                }
            }
        }
        for(int i = 0; i < bobSizes.length; i++){
            int target = sum - bobSum + bobSizes[i];
            int low = 0, high = aliceSizes.length-1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(aliceSizes[mid] == target){
                    return new int[]{aliceSizes[mid], bobSizes[i]};
                }
                else if(aliceSizes[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
        }
        
        return res;
    }
}