package _09_binary_trees;

/**
 * Given : a binary tree
 * Check if it is height balanced or not
 */
public class _71_HeightBalancedTree {

    public boolean isHeightBalanced(TreeNode root) {
        return isHeightBalancedHelper(root).isBalanced;
    }

    private HeightBalanceResponse isHeightBalancedHelper(TreeNode root) {
        if (root == null) {
            return new HeightBalanceResponse(0, true);
        }
        HeightBalanceResponse leftResp = isHeightBalancedHelper(root.getLeft());
        HeightBalanceResponse rightResp = isHeightBalancedHelper(root.getRight());
        int height = 1 + Math.max(leftResp.height, rightResp.height);
        boolean isBalanced = leftResp.isBalanced && rightResp.isBalanced && Math.abs(leftResp.height - rightResp.height) < 2;
        return new HeightBalanceResponse(height, isBalanced);
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        _71_HeightBalancedTree obj = new _71_HeightBalancedTree();
        System.out.println("Is Height Balanced : " + obj.isHeightBalanced(root));
        TreeNode node8 = new TreeNode(8);
        node7.setLeft(node8);
        System.out.println("Is Height Balanced : " + obj.isHeightBalanced(root));
        System.out.println("Is Height Balanced : " + obj.isHeightBalanced(node8));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}

class HeightBalanceResponse {
    public int height;
    public boolean isBalanced;

    public HeightBalanceResponse(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
