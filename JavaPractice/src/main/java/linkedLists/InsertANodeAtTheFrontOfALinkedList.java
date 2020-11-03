/** This question is from Firecode.io
 *
 * Write a method to insert a node at the front of a singly-linked list and return the head of the modified list.
 *
 * Examples:
 * LinkedList: 1->2 , Head = 1
 *
 * InsertAtHead(Head,1) ==> 1->1->2
 * InsertAtHead(Head,2) ==> 2->1->2
 * InsertAtHead(Head,3) ==> 3->1->2
 */

package linkedLists;

// Time: O(1) | Space: O(1)
public class
InsertANodeAtTheFrontOfALinkedList {

    // Defn of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);

        System.out.println(insertAtHead(n,3).val); // new head value is 3
    }
}
