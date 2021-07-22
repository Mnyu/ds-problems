package _09_binary_trees;

import java.util.Deque;
import java.util.LinkedList;

public class _67_LevelOrderTraversal {

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.removeFirst();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null)
                    queue.addLast(node.getLeft());
                if (node.getRight() != null)
                    queue.addLast(node.getRight());
                count--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        _67_LevelOrderTraversal obj = new _67_LevelOrderTraversal();
        obj.levelOrder(root);
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N) [queue]
}
