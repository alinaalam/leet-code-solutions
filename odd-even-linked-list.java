/**
 * Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        return approach2(head);
    }
    
    public ListNode approach1(ListNode head) {
        // sanity check
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = odd.next;
        
        ListNode temp = even.next;
        
        int counter = 3;
        
        while (temp != null) {
            ListNode next = temp.next;
            
            if (counter % 2 != 0) {
                temp.next = odd.next;
                odd.next = temp;
                even.next = next;
                odd = temp;
            } else {
                even = temp;
            }
            
            counter++;
            temp = next;
        }
        
        return head;
    }
    
    public ListNode approach2(ListNode head) {
        // sanity check
        if (head == null) {
            return head;
        }
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}
