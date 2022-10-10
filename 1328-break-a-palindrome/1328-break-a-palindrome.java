class Solution {
    public String breakPalindrome(String palindrome) {
        char[] a = palindrome.toCharArray();
        if(a.length == 1) return "";
        for(int i = 0; i < a.length/2; i++){
            if(a[i] != 'a'){
                a[i] = 'a';
                return new String(a);
            }
        }
        a[a.length-1] = 'b';
        return new String(a);
    }
}