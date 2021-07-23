package _10_bst;

import _09_binary_trees.TreeNode;

class SuccResponse {
    public int succ;
    public boolean elementFound;
    public boolean succFound;

    public SuccResponse(int succ, boolean elementFound, boolean succFound) {
        this.succ = succ;
        this.elementFound = elementFound;
        this.succFound = succFound;
    }
}

public class _80_InorderSuccessor {

    public int inOrderSuccessor(TreeNode root, int target) {
        return inOrderSuccessorRec(root, target).succ;
    }

    private SuccResponse inOrderSuccessorRec(TreeNode root, int target) {
        if (root == null)
            return new SuccResponse(-1, false, false);

        if (target == root.getData()) {
            if (root.getRight() != null) {
                return new SuccResponse(getLeftMostElement(root.getRight()), true, true);
            }
            return new SuccResponse(-1, true, false);
        } else if (target < root.getData()) {
            SuccResponse leftResponse = inOrderSuccessorRec(root.getLeft(), target);
            if (leftResponse.elementFound && !leftResponse.succFound) {
                return new SuccResponse(root.getData(), true, true);
            }
            return leftResponse;
        } else {
            return inOrderSuccessorRec(root.getRight(), target);
        }
    }

    private int getLeftMostElement(TreeNode root) {
        TreeNode start = root;
        while (start.getLeft() != null) {
            start = start.getLeft();
        }
        return start.getData();
    }

    public static void main(String[] args) {
        _80_InorderSuccessor obj = new _80_InorderSuccessor();
        BST bst = new BST();
        int[] arr = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int a : arr) {
            bst.insert(a);
        }
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 1));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 3));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 4));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 6));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 7));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 8));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 10));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 13));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 14));
        System.out.println(obj.inOrderSuccessor(bst.getRoot(), 11));
    }
    // Time Complexity : O(H)
    // Space Complexity : O(H)
}
