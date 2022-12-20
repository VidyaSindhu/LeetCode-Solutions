/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap();
        map.put(0, dummy);
        
        ListNode curr = head;
        ListNode prev = dummy;
        
        int sum = 0;
        while(curr != null){
            sum += curr.val;
            
            if(map.containsKey(sum)){
                ListNode it = map.get(sum).next;
                ListNode tmp = map.get(sum);
                while(it != curr){
                    sum += it.val;
                    map.remove(sum);
                    it = it.next;
                }
                sum += it.val;
                tmp.next = curr.next;
            }
            else{
                map.put(sum, curr);
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}