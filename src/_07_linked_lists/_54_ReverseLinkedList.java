package _07_linked_lists;

/**
 * Reverse a Linked List - Iterative and Recursive
 */
public class _54_ReverseLinkedList {
    public Node<Integer> reverseIterative(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> temp;
        while (curr != null) {
            temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public Node<Integer> reverseRecursive(Node<Integer> head){
        if(head == null || head.getNext() == null){
            return head;
        }
        Node<Integer> newHead = reverseRecursive(head.getNext());
        Node<Integer> temp = head.getNext();
        head.setNext(temp.getNext());
        temp.setNext(head);
        return newHead;
    }

    public static void main(String[] args) {
        _54_ReverseLinkedList obj = new _54_ReverseLinkedList();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        System.out.println(ll);
        ll.setHead(obj.reverseIterative(ll.getHead()));
        System.out.println(ll);
        ll.setHead(obj.reverseRecursive(ll.getHead()));
        System.out.println(ll);
    }
    // Complexity - Recursive Solution
    //      Time : O(N) Space : O(N)
    // Complexity - Iterative Solution
    //      Time : O(N) Space : O(1)
}
