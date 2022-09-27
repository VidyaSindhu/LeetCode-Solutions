class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        
        right[0] = dominoes.charAt(0) == 'R' ? 1 : Integer.MAX_VALUE;
        left[n-1] = dominoes.charAt(n-1) == 'L' ? 1 : Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                right[i] = 1;
            }
            else if(dominoes.charAt(i) == 'L'){
                right[i] = Integer.MAX_VALUE;
            }
            else{
                if(right[i-1] < Integer.MAX_VALUE) right[i] = right[i-1] + 1;
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            
            if(dominoes.charAt(i) == 'L'){
                left[i] = 1;
            }
            else if(dominoes.charAt(i) == 'R'){
                left[i] = Integer.MAX_VALUE;
            }
            else if(left[i+1] < Integer.MAX_VALUE){
                left[i] = left[i+1] + 1;
            }
        }
        // for(int i = 0; i < n; i++){
        //     System.out.print(right[i] + "  ");
        // }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            
            if(left[i] > right[i]){
                sb.append("R");
            }
            else if(left[i] < right[i]){
                sb.append("L");
            }
            else{
                sb.append('.');
            }
        }
        
        return sb.toString();
    }
}