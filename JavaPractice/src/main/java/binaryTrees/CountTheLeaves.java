/** This question is from Firecode.io
 *
 * Write a function to find the total number of leaf nodes in a binary tree. A node is described as a leaf node if it
 * doesn't have any children. If there are no leaf nodes, return 0.
 *
 * Example:
 *        1
 *       / \
 *      2   3
 *     / \ / \
 *    4  5 6  7
 *   / \
 *  8   9
 *          ==> no. of leaves = 5
 */
package binaryTrees;

// Time: O(n) | Space: O(log n)
public class CountTheLeaves {

    // Defn of TreeNode
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static int numberOfLeaves(TreeNode root) {
        // if there are no leaf nodes, return 0
        if (root == null) {
            return 0;
        }
        // if there is only one root node with no children, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // recursively call numberOfLeaves on left child and the right child, returning their sum of leaf nodes
        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8, null, null),
                                new TreeNode(9, null, null)),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        System.out.println(numberOfLeaves(n));
    }
}
