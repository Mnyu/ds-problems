package _10_bst;

import _09_binary_trees.TreeNode;

/**
 * Given BST
 * Convert it to a sorted linked list, right pointer should behave as
 * next pointer for the linked list
 */
public class _79_FlattenBST {

    public void flattenBST(TreeNode root) {
        LLResponse response = flattenBSTRecurr(root);
        TreeNode start = response.head;
        while (start.getRight() != null) {
            System.out.print(start.getData() + "->");
            start = start.getRight();
        }
        System.out.print(start.getData());
    }

    private LLResponse flattenBSTRecurr(TreeNode root) {
        TreeNode head = root;
        TreeNode tail = root;
        if (root.getLeft() != null && root.getRight() != null) {
            LLResponse leftResponse = flattenBSTRecurr(root.getLeft());
            LLResponse rightResponse = flattenBSTRecurr(root.getRight());
            head = leftResponse.head;
            leftResponse.tail.setRight(root);
            root.setRight(rightResponse.head);
            tail = rightResponse.tail;
        } else if (root.getLeft() != null) {
            LLResponse leftResponse = flattenBSTRecurr(root.getLeft());
            head = leftResponse.head;
            leftResponse.tail.setRight(root);
        } else if (root.getRight() != null) {
            LLResponse rightResponse = flattenBSTRecurr(root.getRight());
            root.setRight(rightResponse.head);
            tail = rightResponse.tail;
        }
        root.setLeft(null);
        return new LLResponse(head, tail);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{4, 2, 6, 1, 3, 5, 7};
        for (int a : arr) {
            bst.insert(a);
        }
        _79_FlattenBST obj = new _79_FlattenBST();
        obj.flattenBST(bst.getRoot());
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}

class LLResponse {
    public TreeNode head;
    public TreeNode tail;

    public LLResponse(TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;
    }
}
