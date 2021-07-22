package _09_binary_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given Binary Tree and Target Node T
 * Find all nodes at distance K from T
 */
public class _73_NodesAtDistK {

    public List<Integer> nodesAtDistK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        nodesAtDistK(root, target, k, result);
        return result;
    }

    private int nodesAtDistK(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            collectAtLevelK(root, k, result);
            return 0;
        }
        int distOfTargetOnLeftSide = nodesAtDistK(root.getLeft(), target, k, result);
        if (distOfTargetOnLeftSide != -1) {
            // Case for root
            if (distOfTargetOnLeftSide + 1 == k) {
                result.add(root.getData());
            } else {
                // case for right side of root
                collectAtLevelK(root.getRight(), k - 2 - distOfTargetOnLeftSide, result);
            }
            return 1 + distOfTargetOnLeftSide;
        }

        int distOfTargetOnRightSide = nodesAtDistK(root.getRight(), target, k, result);
        if (distOfTargetOnRightSide != -1) {
            // Case for root
            if (distOfTargetOnRightSide + 1 == k) {
                result.add(root.getData());
            } else {
                // case for left side of root
                collectAtLevelK(root.getLeft(), k - 2 - distOfTargetOnRightSide, result);
            }
            return 1 + distOfTargetOnRightSide;
        }
        return -1;
    }

    private void collectAtLevelK(TreeNode root, int k, List<Integer> result) {
        if (root == null) return;
        if (k == 0) {
            result.add(root.getData());
            return;
        }
        collectAtLevelK(root.getLeft(), k - 1, result);
        collectAtLevelK(root.getRight(), k - 1, result);
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node9, node10);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, node8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        _73_NodesAtDistK obj = new _73_NodesAtDistK();
        System.out.println(obj.nodesAtDistK(root, node5, 2));
        System.out.println(obj.nodesAtDistK(root, node5, 3));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
