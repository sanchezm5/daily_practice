/** This question is from Firecode.io
 *
 * Given a singly-linked list, write a method to delete the first node of the list and return the new head.
 * Example: LinkedList: 1->2->3 , Head = 1
 *          deleteAtHead(Head) ==> 2->3
 */
package linkedLists;

public class DeleteAListsHeadNode {

    // Defn of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode deleteAtHead(ListNode head) {
        if (head == null || head.next == null) return null;

        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);

        System.out.println(n.val);  // head is 1
        System.out.println(deleteAtHead(n).val); // after head is deleted, head is now 2
    }
}
