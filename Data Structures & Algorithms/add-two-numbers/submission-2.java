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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1=l1,cur2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int carry=0,c1=0,c2=0;
        while(cur1!=null)
        {
            c1++;
            cur1=cur1.next;
        }
       System.out.println(c1);
       
        while(cur2!=null)
        {
            c2++;
            cur2=cur2.next;
        }
        cur1=l1;
        cur2=l2;
        System.out.println(c2);
          if(c2>c1)
        return addTwoNumbers( l2,l1);
        System.out.println("^^^^^^^^^^^^^");

         while(cur1!=null || cur2!=null)
        {
            int sum=carry;
            if (cur1!=null)
            {
                sum+=cur1.val;
                  cur1=cur1.next;
            }

            if (cur2!=null)
            {sum+=cur2.val;
              cur2=cur2.next;}
            System.out.println(sum);
            ListNode nn;
            carry=sum/10;

            if (carry>0)
             nn=new ListNode (sum%10);
             else
             {nn=new ListNode (sum);
             carry=0;
             }
             
             temp.next=nn;
             temp=nn;
           
        



        }
        ListNode nn= new ListNode(0);
        if(carry>0)
          
          { nn.val=carry;
          temp.next=nn;
          }

          return dummy.next;
        
    }
}
