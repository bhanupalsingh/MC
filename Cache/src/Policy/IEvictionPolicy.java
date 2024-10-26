package Policy;

public interface IEvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evict();
}
