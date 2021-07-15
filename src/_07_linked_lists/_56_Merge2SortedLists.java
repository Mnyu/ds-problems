package _07_linked_lists;

public class _56_Merge2SortedLists {
    public Node<Integer> mergeSorted(Node<Integer> a, Node<Integer> b) {
        // Base cases
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node<Integer> c;
        if (a.getData() < b.getData()) {
            c = a;
            c.setNext(mergeSorted(a.getNext(), b));
        } else {
            c = b;
            c.setNext(mergeSorted(a, b.getNext()));
        }
        return c;
    }
    public static void main(String[] args) {
        _56_Merge2SortedLists obj = new _56_Merge2SortedLists();
        LinkedList<Integer> A = new LinkedList<>();
        A.insertAtHead(10);
        A.insertAtHead(7);
        A.insertAtHead(5);
        A.insertAtHead(1);
        LinkedList<Integer> B = new LinkedList<>();
        B.insertAtHead(6);
        B.insertAtHead(3);
        B.insertAtHead(2);
        System.out.println(A);
        System.out.println(B);
        LinkedList<Integer> C = new LinkedList<>();
        C.setHead(obj.mergeSorted(A.getHead(),B.getHead()));
        System.out.println(C);
    }
    // Time Complexity : O(N + M)
    // Space Complexity : O(N + M)
}
