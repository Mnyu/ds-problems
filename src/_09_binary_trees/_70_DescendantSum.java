package _09_binary_trees;

public class _70_DescendantSum {
    public int descendantSum(TreeNode root) {
        if (root == null)
            return 0;
        int currData = root.getData();
        int leftSum = descendantSum(root.getLeft());
        int rightSum = descendantSum(root.getRight());
        if (leftSum + rightSum > 0) {
            root.setData(leftSum + rightSum);
        }
        return currData + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        _70_DescendantSum obj = new _70_DescendantSum();
        System.out.println(obj.descendantSum(root));
        _67_LevelOrderTraversal obj2 = new _67_LevelOrderTraversal();
        obj2.levelOrder(root);
    }
    // Time Complexity : O(N) - each node visited once
    // Space Complexity : O(N) - recursion stack
}
