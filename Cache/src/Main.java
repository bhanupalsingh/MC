//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Factory.CacheFactory;
import Model.Cache;
import Model.CacheType;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Cache cache = new CacheFactory<String, String>().getCache(CacheType.LRU, 2);

        cache.set("1", "123");
        cache.set("2", "234");
        cache.set("3", "345");

        System.out.println("GET 3 " + cache.get("3"));
        System.out.println("GET 1 " + cache.get("1"));

    }
}