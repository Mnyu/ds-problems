package _07_linked_lists;

public class _57_MiddleElement {
    public int middleElement(Node<Integer> head) {
        if (head == null) {
            throw new RuntimeException("Head is null");
        }
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

    public static void main(String[] args) {
        _57_MiddleElement obj = new _57_MiddleElement();
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
        System.out.println(obj.middleElement(ll.getHead()));
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.insertAtHead(7);
        ll2.insertAtHead(6);
        ll2.insertAtHead(5);
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        System.out.println(ll2);
        System.out.println(obj.middleElement(ll2.getHead()));
        LinkedList<Integer> ll3 = new LinkedList<>();
        ll3.insertAtHead(7);
        System.out.println(ll3);
        System.out.println(obj.middleElement(ll3.getHead()));
        LinkedList<Integer> ll4 = new LinkedList<>();
        ll4.insertAtHead(7);
        ll4.insertAtHead(8);
        System.out.println(ll4);
        System.out.println(obj.middleElement(ll4.getHead()));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
