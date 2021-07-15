package _07_linked_lists;

public class _60_DetectCycle {
    public boolean isCyclic(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return false;
    }
    public static void main(String[] args) {
        _60_DetectCycle obj = new _60_DetectCycle();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insertAtHead(7);
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        // Create cycle with some custom code
        Node<Integer> node3 = null;
        Node<Integer> node7 = null;
        Node<Integer> curr = ll.getHead();
        while(curr != null){
            if(curr.getData() == 3) {
                node3 = curr;
            }
            if(curr.getData() == 7) {
                node7 = curr;
            }
            curr = curr.getNext();
        }
        node7.setNext(node3);
        System.out.println(obj.isCyclic(ll.getHead()));

        // Test with an acyclic linked list
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.insertAtHead(7);
        ll2.insertAtHead(6);
        ll2.insertAtHead(5);
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        System.out.println(obj.isCyclic(ll2.getHead()));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
