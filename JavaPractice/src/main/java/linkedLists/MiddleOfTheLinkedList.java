/** This question is from LeetCode
 *
 * Given a non-empty, singly linked list with head node, head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Input: [1,2,3,4,5]           Output: Node 3 from this list (Serialization: [3,4,5])
 * Explanation: The returned node has value 3. Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Input: [1,2,3,4,5,6]         Output: Node 4 from this list (Serialization: [4,5,6])
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note: The number of nodes in the given list will be between 1 and 100.
 */

package linkedLists;

public class MiddleOfTheLinkedList {

    // Defn of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
    // Solution 1: Find the middle index of the list
    public static ListNode middleNodeSoln1(ListNode head) {
        ListNode curr = head;
        int numOfNodes = 1;

        // Find the size of the linked list by incrementing the numOfNodes variable
        while(curr.next != null) {
            curr = curr.next;
            numOfNodes++;
        }

        // Reset the current node to head
        // Find the middle index of either odd or even size
        curr = head;
        int middleIndex = (numOfNodes % 2 == 1) ? (numOfNodes - 1) / 2 : numOfNodes/2;

        // Iterate through the list until the middle index is reached and then return that node
        for (int i = 0; i < middleIndex; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // Solution 2(Optimal): Use two pointer technique
    // Time: O(n) | Space: O(1)
    public static ListNode middleNodeSoln2(ListNode head) {
        // assign the head to a slow and fast pointer
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // while the fast pointer or its next value are not equal to null
        // the slow pointer will increment one node at a time
        // and the fast pointer will increment twice as fast
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // when the fast pointer reaches null, return the slow pointer as it will be in the middle of the linked list
        return slowPointer;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);

        // Output is 3 for both methods
        System.out.println(middleNodeSoln1(n).val);
        System.out.println(middleNodeSoln2(n).val);

        // Output is 4
        System.out.println(middleNodeSoln1(n).next.val);
        System.out.println(middleNodeSoln2(n).next.val);

        // Output is 5
        System.out.println(middleNodeSoln1(n).next.next.val);
        System.out.println(middleNodeSoln2(n).next.next.val);
    }
}
