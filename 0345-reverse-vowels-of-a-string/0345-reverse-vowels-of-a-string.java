class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length()-1;
        Set<Character> set = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while(left < right){
            while(left < sb.length() && !set.contains(sb.charAt(left))){
                left++;
            }
            while(right >= 0 && !set.contains(sb.charAt(right))){
                right--;
            }
            if(left >= right) break;
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            
            left++;
            right--;
        }
        
        return sb.toString();
    }
}