class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length < 2) return Arrays.stream(nums).boxed().toList();;
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(num1 == nums[i]){
                count1++;
            }
            else if(num2 == nums[i]){
                count2++;
            }
            else if(count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }
            else if(count2 ==0){
                num2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        List<Integer> ans = new ArrayList();
        
        count1 = 0;
        count2 = 0;
        for(int i : nums){
            if(i == num1){
                count1++;
            }
            else if(i == num2){
                count2++;
            }
            
        }
        if(count1 > nums.length/3){
            ans.add(num1);
        }
        if(count2 > nums.length/3){
            ans.add(num2);
        }
        
        return ans;
    }
}