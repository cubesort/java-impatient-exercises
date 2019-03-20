package ch7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ch7_13 {
    public static void main(String[] args) {
        
    }

    public static class Cache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        Cache(int capacity) {
            super();
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
}
