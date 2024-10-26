package Policy;

import Repo.DoublyLinkedList;
import Repo.Node;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {
    private DoublyLinkedList<Key> linkedList;

    public LRUEvictionPolicy() {
        this.linkedList = new DoublyLinkedList<Key>();
    }

    @Override
    public void keyAccessed(Key key) {
        linkedList.deleteNode(key);
        linkedList.insertAtEnd(key);
    }

    @Override
    public Key evict() {
        Node<Key> node = linkedList.getHead();
        if(node != null)
        {
            linkedList.deleteNode(node.key);
            return node.key;
        }
        return null;
    }
}
