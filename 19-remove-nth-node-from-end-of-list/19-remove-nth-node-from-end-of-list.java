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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode it = dummy;
        while(n > 0){
            it = it.next;
            n--;
        }
        ListNode curr = dummy;
        ListNode prev = null;
        while(it != null){
            prev = curr;
            curr = curr.next;
            it = it.next;
        }
        
        if(prev != null){
            prev.next = prev.next.next;
        }
        
        return dummy.next;
    }
    
    
}