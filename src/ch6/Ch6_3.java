package ch6;

import java.util.ArrayList;

public class Ch6_3 {
    public static void main(String[] args) {
        Table<String, Integer> table = new Table<>();

        table.put("Burr", 1);
        System.out.println(table.get("Burr"));
        table.put("Burr", 2);
        System.out.println(table.get("Burr"));
        table.remove("Burr");
        System.out.println(table.get("Burr"));
    }
}

class Table<K, V> {
    private ArrayList<Entry<K, V>> table = new ArrayList<>();

    public void put (K key, V value) {
        for (Entry<K, V> entry : table) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        table.add(new Entry<>(key, value));
    }

    public V get (K key) {
        for (Entry<K, V> entry : table) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        for (Entry<K, V> entry : table) {
            if (entry.key == key) {
                table.remove(entry);
                return;
            }
        }
    }
}

class Entry<K, V> {
    K key;
    V value;

    Entry (K key, V value) {
        this.key = key;
        this.value = value;
    }
}
