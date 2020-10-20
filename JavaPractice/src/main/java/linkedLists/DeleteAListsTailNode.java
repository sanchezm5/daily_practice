/** This question is from Firecode.io
 *
 * Given a singly-linked list, write a method to delete its last node and return the head.
 * Example: 1->2->3->4 ==> 1->2->3
 */

package linkedLists;

// Time: O(n) | Space: O(1)
public class DeleteAListsTailNode {

    // Defn of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        n.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);

        System.out.println(deleteAtTail(n).val);
        System.out.println(n.next.val);
        System.out.println(n.next.next.val);
        System.out.println(n.next.next.next.val);
    }
}
