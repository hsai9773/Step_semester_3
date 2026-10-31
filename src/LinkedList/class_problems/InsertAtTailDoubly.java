package LinkedList.class_problems;
public class InsertAtTailDoubly {

    static class DNode {
        int data;
        DNode next;
        DNode prev;

        DNode(int data) {
            this.data = data;
        }
    }

    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);

        if (head == null)
            return newNode;

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

        return head;
    }

    static void display(DNode head) {
        DNode current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null)
                System.out.print(" <-> ");

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = insertAtTailDoubly(head, 4);
        display(head);

        DNode head2 = null;
        head2 = insertAtTailDoubly(head2, 7);
        display(head2);
    }
}
