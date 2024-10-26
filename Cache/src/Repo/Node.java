package Repo;

public class Node<Key> {
    public Key key;
    public Node next;
    public Node prev;

    public Node(Key key){
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
