package LinkedList.class_problems;

public class RemoveFirstKNodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k == 0)
            return head;

        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }

        return head;
    }

    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = removeFirstKNodes(head, 2);
        display(head);

        head = removeFirstKNodes(head, 5);
        display(head);
    }
}
