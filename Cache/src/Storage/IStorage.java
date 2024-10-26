package Storage;
import Exception.*;
public interface IStorage<Key,Value> {
    Value get(Key key) throws KeyNotFoundException;
    void update(Key key, Value value) throws StorageFullException;
    void removeKey(Key removedKey);
}
