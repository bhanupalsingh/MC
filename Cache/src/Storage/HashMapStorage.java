package Storage;

import Repo.Node;
import java.util.concurrent.ConcurrentHashMap;
import Exception.KeyNotFoundException;
import Exception.StorageFullException;

public class HashMapStorage<Key,Value> implements IStorage<Key,Value> {
    private ConcurrentHashMap<Key, Value> map;
    private int size;

    public HashMapStorage(int size) {
        this.map = new ConcurrentHashMap<Key,Value>();
        this.size = size;
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        if(map.containsKey(key)){
            return map.get(key);
        }
        throw new KeyNotFoundException("Given key is not present in cache");
    }

    @Override
    public void update(Key key, Value value) throws StorageFullException {
        if(this.size == this.map.size() && !map.containsKey(key)){
            throw new StorageFullException("Storage is already full please evict first and then retry");
        }
        map.put(key, value);
    }

    @Override
    public void removeKey(Key removedKey) {
        if(this.map.containsKey(removedKey)){
            this.map.remove(removedKey);
        }
    }
}
