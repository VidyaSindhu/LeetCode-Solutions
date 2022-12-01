class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int i = 0, j = s.length()-1;
        // Map<Character, Integer> leftHalf = new HashMap();
        // Map<Character, Integer> rightHalf = new HashMap();
        int leftCount = 0, rightCount = 0;
        while(i < j){
            if(set.contains(s.charAt(i))){
                // leftHalf.put(s.charAt(i), leftHalf.getOrDefault(s.charAt(i), 0) + 1);
                leftCount++;
            }
            if(set.contains(s.charAt(j))){
                rightCount++;
                // rightHalf.put(s.charAt(j), rightHalf.getOrDefault(s.charAt(j), 0) + 1);
            }
            i++;
            j--;
        }
        
//         for(int key: set){
//             if(!leftHalf.containsKey(key) && !rightHalf.containsKey(key)) continue;
//             if(!leftHalf.containsKey(key) || 
//                !rightHalf.containsKey(key) || rightHalf.get(key) != leftHalf.get(key)) return false;
//         }
        
//         return true;
        
        return leftCount == rightCount;
    }
}