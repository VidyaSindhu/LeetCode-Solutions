class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        
        Map<Character, String> charWord = new HashMap();
        Map<String, Character> wordChar = new HashMap();
        
        for(int i = 0; i < words.length; i++){
            if(charWord.containsKey(pattern.charAt(i)) && charWord.get(pattern.charAt(i)).equals(words[i])
              && wordChar.containsKey(words[i]) && wordChar.get(words[i]).equals(pattern.charAt(i))) continue;
            
            if(charWord.containsKey(pattern.charAt(i)) && !charWord.get(pattern.charAt(i)).equals(words[i])) 
                return false;
            if(wordChar.containsKey(words[i]) && !wordChar.get(words[i]).equals(pattern.charAt(i))) 
                return false;
            
            charWord.put(pattern.charAt(i), words[i]);
            wordChar.put(words[i], pattern.charAt(i));
        }
        
        return true;
    }
}