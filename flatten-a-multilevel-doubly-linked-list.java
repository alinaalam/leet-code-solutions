/*
* Flatten a Multilevel Doubly Linked List
* https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head != null) {
            helper(head);
        }
        return head;
    }
    
    private Node helper(Node head) {
        Node curr = head, tail = head;
        while (curr != null) {
            Node child = curr.child;
            Node next = curr.next;
            
            if (child != null) {
                Node currTail = helper(child);
                
                currTail.next = next;
                if (next != null) {
                    next.prev = currTail;
                }
                
                curr.next = child;
                child.prev = curr;
                
                curr.child = null;
                
                curr = tail;
            }
            else {
                curr = next;
            }
            if (curr != null) {
                tail = curr;
            }
        }
        return tail;
    }
}
