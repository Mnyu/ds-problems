package _07_linked_lists;

public class LinkedList<T> {

    private Node<T> head;

    public void insertAtHead(T data) {
        if (head == null) {
            head = new Node<>(data,null);
            return;
        }
        head = new Node<>(data, head);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = head;
        while (curr.getNext() != null) {
            sb.append(curr.getData().toString()).append("=>");
            curr = curr.getNext();
        }
        sb.append(curr.getData().toString());
        return sb.toString();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
