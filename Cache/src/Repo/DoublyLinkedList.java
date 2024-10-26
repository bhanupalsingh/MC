package Repo;

public class DoublyLinkedList<Key> {
    private Node head;
    private Node tail;


    // Insert a node at the end of the list
    public void insertAtEnd(Key data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode; // Link the old tail to the new node
            newNode.prev = tail; // Link the new node to the old tail
            tail = newNode;      // Update the tail
        }
    }

    // Insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head; // Link the new node to the old head
            head.prev = newNode; // Link the old head to the new node
            head = newNode;      // Update the head
        }
    }

        // Delete a node from the list by value
    public void deleteNode(Key data) {
        Node current = head;

        while (current != null && current.key != data) {
            current = current.next;
        }

        if (current == null) { // Data not found
            //System.out.println("Node not found.");
            return;
        }

        if (current == head) { // If the node to delete is the head
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) { // If the node to delete is the tail
            tail = current.prev;
            tail.next = null;
        } else { // If the node is in the middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Display the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead()
    {
        if(this.head == null){
            return null;
        }
        return this.head;
    }
}