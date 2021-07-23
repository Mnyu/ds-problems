package _10_bst;

import _09_binary_trees.TreeNode;

public class _78_ClosestValue {

    public int closestValue(TreeNode root, int target) {
        if(root == null){
            return 0;
        }
        if (target == root.getData()) {
            return target;
        }
        else if(target < root.getData()) {
            int left = closestValue(root.getLeft(), target);
            if (Math.abs(left - target) < Math.abs(root.getData() - target)) {
                return left;
            }
        } else {
            int right = closestValue(root.getRight(), target);
            if (Math.abs(right - target) < Math.abs(root.getData() - target)) {
                return right;
            }
        }
        return root.getData();
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int a : arr) {
            bst.insert(a);
        }
        _78_ClosestValue obj = new _78_ClosestValue();
        System.out.println(obj.closestValue(bst.getRoot(), 16));
        System.out.println(obj.closestValue(bst.getRoot(), 1));
        System.out.println(obj.closestValue(bst.getRoot(), 11));
        System.out.println(obj.closestValue(bst.getRoot(), 5));
        System.out.println(obj.closestValue(bst.getRoot(), 17));
        System.out.println(obj.closestValue(bst.getRoot(), 12));
    }

    // Time Complexity : O(H)
    // Space Complexity : O(H)
    // This can also e solved iteratively which will optimize space complexity to O(1).
}
