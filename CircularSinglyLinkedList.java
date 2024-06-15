package dsaCodes;

public class CircularSinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular connection
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Update tail's next to point to head
        }
        size++;
    }

    // Insertion at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular connection
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Update tail's next to point to head
        }
        size++;
    }

    // Insertion at a specific position
    public void insertAtPosition(int position, int data) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 0) {
            insertAtBeginning(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Deletion at the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head; // Update tail's next to point to new head
        }
        size--;
    }

    // Deletion at the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head; // Update current node's next to point to head
            tail = current; // Update tail to the previous node
        }
        size--;
    }

    // Deletion at a specific position
    public void deleteFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (position == 0) {
            deleteFromBeginning();
        } else if (position == size - 1) {
            deleteFromEnd();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    // Utility function to print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println(" (Head)");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList cll = new CircularSinglyLinkedList();

        // Insertions
        cll.insertAtBeginning(3);
        cll.insertAtEnd(5);
        cll.insertAtEnd(7);
        cll.printList();  // Output: 3 -> 5 -> 7 ->  (Head)

        // Insert at specific position
        cll.insertAtPosition(2, 6);
        cll.printList();  // Output: 3 -> 5 -> 6 -> 7 ->  (Head)

        // Deletions
        cll.deleteFromBeginning();
        cll.printList();  // Output: 5 -> 6 -> 7 ->  (Head)

        cll.deleteFromEnd();
        cll.printList();  // Output: 5 -> 6 ->  (Head)

        cll.deleteFromPosition(1);
        cll.printList();  // Output: 5 ->  (Head)
    }
}
