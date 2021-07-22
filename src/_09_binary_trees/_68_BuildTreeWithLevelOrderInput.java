package _09_binary_trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Eg Input : 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * -1 represents null node
 */
public class _68_BuildTreeWithLevelOrderInput {
    public TreeNode buildTreeFromLevelOrder(int[] input) {
        if (input == null || input.length == 0) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        queue.addLast(root);
        int i = 1;
        TreeNode node = root;
        while (i < input.length) {
            if (i % 2 != 0) {
                node = queue.removeFirst();
                TreeNode leftChild = input[i] != -1 ? new TreeNode(input[i]) : null;
                if (leftChild != null) {
                    queue.addLast(leftChild);
                }
                node.setLeft(leftChild);
            } else {
                TreeNode rightChild = input[i] != -1 ? new TreeNode(input[i]) : null;
                if (rightChild != null) {
                    queue.addLast(rightChild);
                }
                node.setRight(rightChild);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        _68_BuildTreeWithLevelOrderInput obj = new _68_BuildTreeWithLevelOrderInput();
        _67_LevelOrderTraversal obj2 = new _67_LevelOrderTraversal();
        TreeNode root = obj.buildTreeFromLevelOrder(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1});
        obj2.levelOrder(root);
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N) [queue]
}
