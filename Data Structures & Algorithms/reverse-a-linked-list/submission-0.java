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
    public ListNode reverseList(ListNode head) {

        ListNode cur=head, right=null, left=null;
        while(cur!=null)
        {
            left=right;
            right=cur;
            cur=cur.next;
            right.next=left;
        }
        head=right;
        return head;
        
    }
}
