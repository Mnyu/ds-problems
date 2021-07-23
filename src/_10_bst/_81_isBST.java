package _10_bst;

import _09_binary_trees.TreeNode;

public class _81_isBST {

    private boolean isBST(TreeNode root) {
        if (root == null) return false;
        return isBstRecur(root);
    }
    private boolean isBstRecur(TreeNode root) {
        if (root.getLeft() != null && root.getRight() != null) {
            return root.getData() > root.getLeft().getData()
                    && root.getData() <= root.getRight().getData()
                    && isBST(root.getLeft())
                    && isBST(root.getRight());
        }
        if (root.getLeft() != null) {
            return root.getData() > root.getLeft().getData()
                    && isBST(root.getLeft());
        }
        if (root.getRight() != null) {
            return root.getData() <= root.getRight().getData()
                    && isBST(root.getRight());
        }
        return true;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int a : arr) {
            bst.insert(a);
        }
        _81_isBST obj = new _81_isBST();
        System.out.println(obj.isBST(null));
        System.out.println(obj.isBST(bst.getRoot()));

        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        System.out.println(obj.isBST(root));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(H)
}
