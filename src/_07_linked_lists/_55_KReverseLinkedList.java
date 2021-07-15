package _07_linked_lists;

/**
 * Given : Linked List
 * Write a function to reverse every k set of nodes
 */
public class _55_KReverseLinkedList {
    public Node<Integer> kReverse(Node<Integer> head, int k) {
        if(head == null){
            return null;
        }
        int count = 1;
        Node<Integer> prev = null;
        Node<Integer> temp;
        Node<Integer> curr = head;
        while(curr != null && count <= k) {
            temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
            count++;
        }
        if(curr != null){
            head.setNext(kReverse(curr, k));
        }
        return prev;
    }

    public static void main(String[] args) {
        _55_KReverseLinkedList obj = new _55_KReverseLinkedList();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insertAtHead(8);
        ll.insertAtHead(7);
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        System.out.println(ll);
        ll.setHead(obj.kReverse(ll.getHead(), 3));
        System.out.println(ll);
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N/K)
}
