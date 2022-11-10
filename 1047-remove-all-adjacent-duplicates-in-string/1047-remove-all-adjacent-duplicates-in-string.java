class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque();
        
        for(char c: s.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}