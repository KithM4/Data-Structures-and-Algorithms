package dsaCodes;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insertion at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Insertion at a specific position
    public void insertAtPosition(int position, int data) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            int index = 0;
            while (current != null && index < position - 1) {
                current = current.next;
                index++;
            }
            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
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
            head.prev = null;
        }
    }

    // Deletion at the end
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Deletion at a specific position
    public void deleteFromPosition(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            deleteFromBeginning();
        } else {
            Node current = head;
            int index = 0;
            while (current != null && index < position - 1) {
                current = current.next;
                index++;
            }
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            Node nodeToDelete = current.next;
            current.next = nodeToDelete.next;
            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = current;
            }
            if (nodeToDelete == tail) {
                tail = current;
            }
        }
    }

    // Utility function to print the list forward
    public void printListForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("None");
    }

    // Utility function to print the list backward
    public void printListBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(3);
        dll.insertAtEnd(5);
        dll.insertAtPosition(1, 4);
        dll.printListForward();  // Output: 3 <-> 4 <-> 5 <-> None

        dll.deleteFromBeginning();
        dll.printListForward();  // Output: 4 <-> 5 <-> None

        dll.deleteFromEnd();
        dll.printListForward();  // Output: 4 <-> None

        dll.insertAtEnd(6);
        dll.insertAtEnd(7);
        dll.deleteFromPosition(1);
        dll.printListForward();  // Output: 4 <-> 7 <-> None

        dll.printListBackward(); // Output: 7 <-> 4 <-> None
    }
}
