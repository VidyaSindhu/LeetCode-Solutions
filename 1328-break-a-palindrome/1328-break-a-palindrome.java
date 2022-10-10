class Solution {
    public String breakPalindrome(String palindrome) {
        char[] a = palindrome.toCharArray();
        if(a.length == 1) return "";
        boolean done = false;
        for(int i = 0; i < a.length/2; i++){
            if(a[i] != 'a'){
                done = true;
                a[i] = 'a';
                break;
            }
        }
        if(!done) {
            a[a.length-1] = (char)(a[a.length-1] + 1);
        }
        return new String(a);
    }
}