class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(Math.abs(stack.peek() - c) == 32){
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            else{
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}