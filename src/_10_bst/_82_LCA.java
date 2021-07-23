package _10_bst;

import _09_binary_trees.TreeNode;

public class _82_LCA {
    public TreeNode lca(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.getData() > a && root.getData() > b) {
            return lca(root.getLeft(), a, b);
        }
        if (root.getData() < a && root.getData() < b) {
            return lca(root.getRight(), a, b);
        }

        if (root.getData() == a && (isPresent(root.getRight(), b) ||
                isPresent(root.getLeft(), b))) {
                return root;

        } else if (root.getData() == b && (isPresent(root.getRight(), a) ||
                isPresent(root.getLeft(), a))) {
                return root;
        } else if (root.getData() < a && root.getData() > b) {
            if (isPresent(root.getRight(), a) && isPresent(root.getLeft(), b)) {
                return root;
            }
        } else if (root.getData() > a && root.getData() < b) {
            if (isPresent(root.getRight(), b) && isPresent(root.getLeft(), a)) {
                return root;
            }
        }
        return null;
    }

    private boolean isPresent(TreeNode root, int x) {
        if (root == null) return false;
        if (x == root.getData()) return true;
        if (x < root.getData())
            return isPresent(root.getLeft(), x);
        return isPresent(root.getRight(), x);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{5,2,12,-4,3,9,21,19,25};
        for (int a : arr) {
            bst.insert(a);
        }
        _82_LCA obj = new _82_LCA();
        TreeNode node = obj.lca(bst.getRoot(), 9,25);
        System.out.println(node != null ? node.getData() : "NULL");
        node = obj.lca(bst.getRoot(), 9,3);
        System.out.println(node != null ? node.getData() : "NULL");
        node = obj.lca(bst.getRoot(), 9,12);
        System.out.println(node != null ? node.getData() : "NULL");
        node = obj.lca(bst.getRoot(), 7,19);
        System.out.println(node != null ? node.getData() : "NULL");
    }
    // Time Complexity : O(H)
    // Space Complexity : O(H)
}
