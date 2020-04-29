/** This question is from LeetCode
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 *              There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 *              There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Explanation: The two lists do not intersect, so return null.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

package linkedLists;

// Solution: Use two pointer technique
// Time: O(m+n) | Space: O(1)
public class IntersectionOfTwoLinkedLists {

    // Defn for Singly Linked List
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Create two pointers, one pointing at headA and one pointing at headB
        ListNode pA = headA;
        ListNode pB = headB;

        // while the two pointers are not pointing to the same node
        // if the pointer reaches the tail of headA, move the pointer to headB
        // otherwise move the pointer to the next node in the list
        // do the same for pointerB
        while (pA != pB) {
            if (pA == null) pA = headB;
            else pA = pA.next;

            if (pB == null) pB = headA;
            else pB = pB.next;
        }
        // once the pointers are at the same node, return one of the nodes
        // Note: if the pointers both end up pointing to the tail, null will be returned
        return pA;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        a.next = new ListNode(9);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(4);

        ListNode b = new ListNode(3);
        b.next = a.next.next.next;
        b.next.next = a.next.next.next.next;

        System.out.println(getIntersectionNode(a, b));
    }
}
