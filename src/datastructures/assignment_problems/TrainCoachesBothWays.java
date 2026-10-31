package datastructures.assignment_problems;



class Node1 {
    String data;
    Node1 next;
    Node1 prev;

    Node1(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList {
    Node1 head;
    Node1 tail;

    void addLast(String name) {
        Node1 newNode = new Node1(name);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void remove(String name) {
        Node1 current = head;

        while (current != null && !current.data.equals(name)) {
            current = current.next;
        }

        if (current == null)
            return;

        if (current == head)
            head = current.next;
        else
            current.prev.next = current.next;

        if (current == tail)
            tail = current.prev;
        else
            current.next.prev = current.prev;

        current.next = null;
        current.prev = null;
    }

    void printForward() {
        Node1 current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data);
            
            if (current.next != null)
                System.out.print(" <-> ");

            current = current.next;
        }

        System.out.println();
    }

    void printBackward() {
        Node1 current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.prev != null)
                System.out.print(" <-> ");

            current = current.prev;
        }

        System.out.println();
    }
}

public class TrainCoachesBothWays {
    public static void main(String[] args) {

        DoublyLinkedList train = new DoublyLinkedList();

        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
