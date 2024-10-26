package Factory;

import Model.Cache;
import Model.CacheType;
import Policy.LRUEvictionPolicy;
import Storage.HashMapStorage;

public class CacheFactory<Key,Value> {

    public Cache<Key,Value> getCache(CacheType cacheType, int size){
        Cache<Key,Value>  cache;
        switch (cacheType){
            case CacheType.LRU :
                cache = new Cache(new HashMapStorage<Key, Value>(size), new LRUEvictionPolicy<Key>());
                break;
            default:
                cache = new Cache(new HashMapStorage<Key,Value>(size), new LRUEvictionPolicy<Key>());
                break;
        }
        return cache;
    }
}
