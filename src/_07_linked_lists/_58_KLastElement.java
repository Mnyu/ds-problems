package _07_linked_lists;

public class _58_KLastElement {
    public int kLastElement(Node<Integer> head, int k) {
        if(head == null) {
            throw new RuntimeException("Head is null");
        }
        Node<Integer> curr = head;
        Node<Integer> ans = head;
        int i = 1;
        while(curr.getNext() != null){
            if(i >= k) {
                ans = ans.getNext();
            }
            curr = curr.getNext();
            i++;
        }
        return ans.getData();
    }

    public static void main(String[] args) {
        _58_KLastElement obj = new _58_KLastElement();
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
        System.out.println(obj.kLastElement(ll.getHead(), 1));
        System.out.println(obj.kLastElement(ll.getHead(), 2));
        System.out.println(obj.kLastElement(ll.getHead(), 3));
        System.out.println(obj.kLastElement(ll.getHead(), 4));
        System.out.println(obj.kLastElement(ll.getHead(), 5));
        System.out.println(obj.kLastElement(ll.getHead(), 6));
        System.out.println(obj.kLastElement(ll.getHead(), 7));
        System.out.println(obj.kLastElement(ll.getHead(), 8));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
