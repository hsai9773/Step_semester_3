package datastructures.assignment_problems;


class CircularNode {
    String data;
    CircularNode next;

    CircularNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    CircularNode tail;

    void addLast(String name) {
        CircularNode newNode = new CircularNode(name);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    void printTurns(int turns) {
        if (tail == null)
            return;

        CircularNode current = tail.next;

        for (int i = 0; i < turns; i++) {
            System.out.print(current.data);

            if (i < turns - 1)
                System.out.print(" ");

            current = current.next;
        }

        System.out.println();
    }
}

public class RoundRobinGameTurns {
    public static void main(String[] args) {

        CircularLinkedList players = new CircularLinkedList();

        players.addLast("Asha");
        players.addLast("Ravi");
        players.addLast("Neha");

        players.printTurns(7);
    }
}

