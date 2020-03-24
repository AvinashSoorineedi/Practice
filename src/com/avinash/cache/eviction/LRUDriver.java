package com.avinash.cache.eviction;

/*
 * Least Recently Used
 */
public class LRUDriver {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.getFromCache("A", 1);
        cache.getFromCache("B", 2);
        cache.getFromCache("C", 3);
        cache.getFromCache("A", 4);

    }

}
