class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> combinations = new ArrayList();
        combinations.add(0);
        int maxLength = 0;
        
        for(String s: arr){
            int curr = 0;
            boolean found = true;
            for(char c : s.toCharArray()){
                if(((curr >> (c-'a')) & 1) == 1){
                    found = false;
                    break;
                }
                curr |= (1 << (c-'a'));
            }
            
            if(!found) continue;
            
            for(int i = 0; i < combinations.size(); i++){
                if((curr & combinations.get(i)) > 0) continue;
                combinations.add(curr | combinations.get(i));
                maxLength = Integer.max(maxLength, Integer.bitCount(curr | combinations.get(i)));
            }
        }
        
        return maxLength;
    }
}