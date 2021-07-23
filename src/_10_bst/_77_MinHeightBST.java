package _10_bst;

import _09_binary_trees.TreeNode;
import _09_binary_trees._67_LevelOrderTraversal;

public class _77_MinHeightBST {

    public TreeNode minHeightBST(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        return minHeightBST(arr, 0, arr.length - 1);
    }

    private TreeNode minHeightBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeft(minHeightBST(arr, start, mid - 1));
        root.setRight(minHeightBST(arr, mid + 1, end));
        return root;
    }

    public static void main(String[] args) {
        _77_MinHeightBST obj = new _77_MinHeightBST();
        TreeNode root = obj.minHeightBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        _67_LevelOrderTraversal obj2 = new _67_LevelOrderTraversal();
        obj2.levelOrder(root);
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
