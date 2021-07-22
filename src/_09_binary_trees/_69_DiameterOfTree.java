package _09_binary_trees;

class NodeResponse {
    public int diameter;
    public int height;

    NodeResponse(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

public class _69_DiameterOfTree {
    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int d1 = height(root.getLeft()) + height(root.getRight()); // This O(N)
        int d2 = diameter(root.getLeft());
        int d3 = diameter(root.getRight());
        return Math.max(d1, Math.max(d2, d3));
    }
    // Time Complexity of diameter function is :
    // O(N * N) = O(N^2) -- at each node we do N work for calculating height.

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOptimized(TreeNode root) {
        return diameterHelper(root).diameter;
    }

    private NodeResponse diameterHelper(TreeNode root) {
        if (root == null)
            return new NodeResponse(0, 0);
        NodeResponse leftResp = diameterHelper(root.getLeft());
        NodeResponse rightResp = diameterHelper(root.getRight());
        int height = 1 + Math.max(leftResp.height, rightResp.height);
        int d1 = leftResp.height + rightResp.height;
        int diameter = Math.max(d1, Math.max(leftResp.diameter, rightResp.diameter));
        return new NodeResponse(height, diameter);
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, null, node6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        _69_DiameterOfTree obj = new _69_DiameterOfTree();
        System.out.println(obj.diameter(root));
        System.out.println("************ Now Optimized : **********");
        System.out.println(obj.diameterOptimized(root));
    }
    // Time Complexity : O(N) -- with optimized, we visit each node only once and do O(1) work there.
    // Space Complexity : O(N) [stack]
}
