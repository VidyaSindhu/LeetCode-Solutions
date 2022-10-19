class Solution {
    public int compress(char[] chars) {
        HashMap<Character, Integer> map = new HashMap();
        
        int res = 0;
        char lastChar = chars[0];
        for(char c : chars){
            if(c != lastChar){
                int freq = map.get(lastChar);
                if(freq > 0){
                    StringBuilder s = countDigits(freq);
                    chars[res++] = lastChar;
                    for(int j = 0; res < chars.length && freq > 1 && j < s.length(); j++){
                        chars[res++]= s.charAt(j);
                    }
                }
                map.put(lastChar, 0);
                lastChar = c;
                map.put(lastChar, 1);
            }
            else{
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        int freq = map.get(lastChar);
        if(freq > 0){
            StringBuilder s = countDigits(freq);
            // System.out.println(s);
            chars[res++] = lastChar;
            for(int j = 0; res < chars.length && freq > 1 && j < s.length(); j++){
                chars[res++]= s.charAt(j);
            }
        }
        
        return res;
    }
    
    StringBuilder countDigits(int num){
        StringBuilder s = new StringBuilder();
        while(num != 0){
            s.append(num%10);
            num /= 10;
        }
        return s.reverse();
    }
}