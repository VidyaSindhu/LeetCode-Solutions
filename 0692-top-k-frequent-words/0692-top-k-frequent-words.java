class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        TreeSet<String> set = new TreeSet<>((a, b) ->{
            if(!map.get(a).equals(map.get(b))) return map.get(b) - map.get(a);
            // System.out.println(a + " " + b + " " + compare(a, b));
            return compare(a, b);
        });
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
            // set.add(word);
        }
        for(String key: map.keySet()){
            set.add(key);
        }
        // System.out.println(set);
        List<String> res = new ArrayList();
        int i = 0;
        for(String word: set){
            if(i == k) return res;
            res.add(word);
            i++;
        }
        // Collections.sort(res);
        return res;
    }
    
    int compare(String s1, String s2){
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) < s2.charAt(j)) return -1;
            else if(s1.charAt(i) > s2.charAt(j)) return 1;
            i++;
            j++;
        }
        
        if(i == s1.length() && j == s2.length()) return 0;
        if(j == s2.length()) return 1;
        return 0-1;
    }
}

