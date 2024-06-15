package dsaCodes;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Insertion at a specific position
    public void insertAtPosition(int position, int data) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Deletion at the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Deletion at the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // Deletion at a specific position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            current = current.next;
        }
        if (current.next == null) {
            throw new IndexOutOfBoundsException("Position out of range");
        }
        current.next = current.next.next;
    }

    // Utility function to print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        // Perform operations to test the linked list
        sll.insertAtBeginning(3);
        sll.insertAtEnd(5);
        sll.insertAtPosition(1, 4);
        sll.printList();  // Output: 3 -> 4 -> 5 -> None
        
        sll.deleteFromBeginning();
        sll.printList();  // Output: 4 -> 5 -> None
        
        sll.deleteFromEnd();
        sll.printList();  // Output: 4 -> None
        
        sll.insertAtEnd(6);
        sll.insertAtEnd(7);
        sll.deleteFromPosition(1);
        sll.printList();  // Output: 4 -> 7 -> None
    }
}
