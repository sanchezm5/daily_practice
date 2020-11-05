/** This question is from Firecode.io
 *
 * Write a method to insert a node at the end of a singly-linked list. Return the head of the modified list.
 *
 * Examples:
 * LinkedList: 1->2 , Head = 1
 *
 * InsertAtTail(Head,1) ==> 1->2->1
 * InsertAtTail(Head,2) ==> 1->2->2
 * InsertAtTail(Head,3) ==> 1->2->3
 */

package linkedLists;

// Time: O(n) | Space: O(1)
public class InsertANodeAtTheEndOfALinkedList {

    // Defn of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode insertAtTail(ListNode head, int data) {

        ListNode n = new ListNode(data);
        ListNode curr = head;

        if (head == null) {
            head = n;
            return head;
        }

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        insertAtTail(n, 3);
    }
}
