package _09_binary_trees;

/**
 * Find the largest sum of a subset of nodes in a binary tree,
 * such that if a node is included in the sum then its parent and children
 * must not be included in the subset sum.
 */
public class _72_MaxSubsetSum {
    public int maxSubsetSum(TreeNode root) {
        if(root == null)
            return 0;
        int s1 = root.getData();
        if (root.getLeft() != null) {
            s1 = s1 + maxSubsetSum(root.getLeft().getLeft()) + maxSubsetSum(root.getLeft().getRight());
        }
        if (root.getRight() != null) {
            s1 = s1 + maxSubsetSum(root.getRight().getLeft()) + maxSubsetSum(root.getRight().getRight());
        }
        int s2 = maxSubsetSum(root.getLeft()) + maxSubsetSum(root.getRight());
        return Math.max(s1, s2);
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        _72_MaxSubsetSum obj = new _72_MaxSubsetSum();
        System.out.println(obj.maxSubsetSum(root));
    }
    // Time Complexity : O(N) - visit each node only once and do O(1) work on each node.
    // Space Complexity : O(N)
}
