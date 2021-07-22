package _09_binary_trees;

import java.util.ArrayList;
import java.util.List;

public class _75_LeftView {

    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftView(root, result);
        return result;
    }

    public void leftView(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.getData());
        if (root.getLeft() != null) {
            leftView(root.getLeft(), result);
        } else {
            leftView(root.getRight(), result);
        }
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        _75_LeftView obj = new _75_LeftView();
        System.out.println(obj.leftView(root));

        TreeNode _node6 = new TreeNode(6);
        TreeNode _node5 = new TreeNode(5);
        TreeNode _node4 = new TreeNode(4, null, _node5);
        TreeNode _node3 = new TreeNode(3, null, _node6);
        TreeNode _node2 = new TreeNode(2, null, _node4);
        TreeNode _root = new TreeNode(1, _node2, _node3);
        System.out.println(obj.leftView(_root));
    }
    // Time Complexity : O(N) - worst case skew tree
    // Space Complexity : O(N) - recursion stack
}
