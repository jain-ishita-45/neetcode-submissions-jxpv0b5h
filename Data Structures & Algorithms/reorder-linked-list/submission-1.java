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
    public void reorderList(ListNode head) {
        int c=0,k=0;
        
        ListNode cur=head,prev=null;
        while(cur!=null)
        {
            cur=cur.next;
            c++;
        }
        if(c==1) return;
        k=c/2;
        cur=head;
        while(k!=0)
        {
            prev=cur;
            cur=cur.next;
            k--;
        }
        prev.next=null;
        ListNode head2=cur,right=null,left=null;
        while(cur!=null)
        {
            left=right;
            right=cur;
            cur=cur.next;
            right.next=left;
        }
        head2=right;
       ListNode cur1=head, temp1=cur1, cur2=head2,temp2=cur2;
       while(cur1!=null && cur2!=null)
       {
        temp1=cur1.next;
        cur1.next=cur2;
        temp2=cur2.next;
        cur2.next=temp1;
        cur1=temp1;
        cur2=temp2;
       } 
       ListNode c1=head;
       while(c1.next!=null)
       c1=c1.next;

       if(cur2!=null ) c1.next=cur2;
       if(cur1!=null) c1.next=cur1;

        
    }
}
