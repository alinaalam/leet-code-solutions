/**
 * Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                if (prev != null) {
                    prev.next = curr.next;
                }
                ListNode temp = curr;
                curr = curr.next;
                if (temp == head) {
                    head = curr;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
