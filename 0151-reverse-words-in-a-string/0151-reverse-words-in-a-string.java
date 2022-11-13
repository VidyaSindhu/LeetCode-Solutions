class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
            else if(!sb.isEmpty()){
                stack.push(sb.toString());
                sb = new StringBuilder();
            }
            else{
                while(i < s.length() && s.charAt(i) == ' '){
                    i++;
                }
                i--;
            }
        }
        if(!sb.isEmpty()){
            stack.push(sb.toString());
            sb = new StringBuilder();
        }
        
        while(stack.size() > 1){
            sb.append(stack.poll());
            sb.append(' ');
        }
        sb.append(stack.poll());
        return sb.toString();
    }
}