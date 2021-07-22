package _09_binary_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _74_VerticalOrderPrint {

    public void verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        collectNodesVertically(root, 0, map);
        Map<Integer, List<Integer>> sortedMap = new TreeMap<>(map);
        sortedMap.forEach((key, list) -> {
            list.forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    private void collectNodesVertically(TreeNode root, int distance, Map<Integer, List<Integer>> map) {
        if(root == null) return;
        if(map.get(distance) == null) {
            map.put(distance, new ArrayList<>());
        }
        map.get(distance).add(root.getData());
        collectNodesVertically(root.getLeft(), distance - 1, map);
        collectNodesVertically(root.getRight(), distance + 1, map);
    }

    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, null, node9);
        TreeNode node6 = new TreeNode(6, null, node8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        _74_VerticalOrderPrint obj = new _74_VerticalOrderPrint();
        obj.verticalTraversal(root);
    }
    // Time Complexity : O(N) [traversing each node] + O(NlogN) [worst case for tree map - skew trees]
    //                  ~ O(NlogN)
    // Space Complexity : O(N)
}
