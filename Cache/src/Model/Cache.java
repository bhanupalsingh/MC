package Model;

import Policy.IEvictionPolicy;
import Storage.IStorage;
import Exception.*;

public class Cache<Key, Value> {
    private IStorage<Key,Value> storage;
    private IEvictionPolicy<Key> evictionPolicy;

    public Cache(IStorage<Key,Value> storage, IEvictionPolicy<Key> evictionPolicy)
    {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key)
    {
        try{
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }catch(KeyNotFoundException keyNotFoundException){
            System.out.println("Key "+ key.toString() + " not found in cache.");
        }

        return null;
    }

    public void set(Key key, Value value)
    {
        try{
            storage.update(key,value);
            evictionPolicy.keyAccessed(key);
        }catch(StorageFullException storageFullException)
        {
            Key removedKey = evictionPolicy.evict();
            if(removedKey != null) {
                storage.removeKey(removedKey);
                System.out.println("removed key " + removedKey.toString());
                set(key, value);
            }
        }
    }
}
