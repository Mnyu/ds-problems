package _07_linked_lists;

public class _59_MergeSortLinkedList {
    public Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<Integer> mid = getMid(head);
        Node<Integer> a = head;
        Node<Integer> b = mid.getNext();
        mid.setNext(null);

        a = mergeSort(a);
        b = mergeSort(b);
        return merge(a, b);
    }
    private Node<Integer> getMid(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head.getNext();
        while (fast != null && fast.getNext()!= null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    private Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node<Integer> c;
        if (a.getData() < b.getData()) {
            c = a;
            c.setNext(merge(a.getNext(), b));
        } else {
            c = b;
            c.setNext(merge(a, b.getNext()));
        }
        return c;
    }

    public static void main(String[] args) {
        _59_MergeSortLinkedList obj = new _59_MergeSortLinkedList();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insertAtHead(10);
        ll.insertAtHead(7);
        ll.insertAtHead(5);
        ll.insertAtHead(1);
        ll.insertAtHead(17);
        ll.insertAtHead(2);
        ll.insertAtHead(14);
        System.out.println(ll);
        ll.setHead(obj.mergeSort(ll.getHead()));
        System.out.println(ll);
    }
    // Time Complexity : O(NlogN)
    // Space Complexity : O(N)
}
