package _10_bst;

import _09_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private TreeNode root;

    public TreeNode insert(int data) {
        root = insert(root, data);
        return root;
    }

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);
        if (data < root.getData()) {
            root.setLeft(insert(root.getLeft(), data));
        } else {
            root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft(), result);
        result.add(root.getData());
        inOrderTraversal(root.getRight(), result);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int a : arr) {
            bst.insert(a);
        }
        System.out.println(bst.inOrderTraversal());
    }
    // Insert - Time Complexity : O(H) [logN<=H<=N], Space : O(1)
    // Traversal - Time Complexity : O(N) , Space : O(N)
}
