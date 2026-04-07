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

        ListNode cur = head;
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;
        }

        int removeIndex = size - n;
        if(removeIndex == 0){
            return head.next;
        }
        
        cur = head;
        for(int i = 0; i < removeIndex; i++){
            if(i == removeIndex - 1){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
    return head;
    }
}
