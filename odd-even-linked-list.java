/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode l = odd;
        int i = 3;
        ListNode temp = head.next.next;
        
        while (temp != null) {
            System.out.println("BEFORE:");
            System.out.println("Odd value: " + odd.val);
            System.out.println("i: " + i);
            System.out.println("Odd next value: " + odd.next.val);
            System.out.println("Temp value: " + temp.val);
            ListNode t = temp.next;
            if (i % 2 != 0) {
                temp.next = odd.next;
                odd.next = temp;
                odd = temp;
            }
            temp = t;
            i++;
            
            System.out.println("AFTER:");
            System.out.println("Odd value: " + odd.val);
            System.out.println("i: " + i);
            System.out.println("Odd next value: " + odd.next.val);
            // System.out.println("Temp value: " + temp.val);
        }
        
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
        
        return l;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     public ListNode oddEvenList(ListNode head) {
        
//         ListNode odd = head;
//         ListNode even = head.next;
        
//         int i = 1;
        
//         while (odd != NULL) {
//             if (i % 2 == 0) {
                
//             }
//             odd = odd.next;
//         }
//     }
}
