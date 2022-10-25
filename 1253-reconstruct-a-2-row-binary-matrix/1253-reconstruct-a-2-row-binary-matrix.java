class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        res.add(new ArrayList());
        
        int inUpper = upper;
        int inLower = lower;
        int totalCol = 0;
        for(int sum: colsum){
            if(sum == 2){
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
                // totalCol += sum
            }
            else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        
        for(int i = 0; i < colsum.length; i++){
            if(colsum[i] == 1){
                if(upper > 0){
                    res.get(0).set(i, 1);
                    upper--;
                }
                else if(lower > 0){
                    res.get(1).set(i, 1);
                    lower--;
                }
                else return new ArrayList();
            }
        }
        
        return isValid(inLower, inUpper, res) ? res : new ArrayList();
    }
    
    boolean isValid(int lower, int upper, List<List<Integer>> res){
        int up = 0, low = 0;
        
        for(int num : res.get(0)){
            up += num;
        }
        for(int num : res.get(1)){
            low += num;
        }
        
        return up == upper && low == lower;
    }
}