package ch6;

import java.util.ArrayList;

public class Ch6_4 {
    public static void main(String[] args) {
        TableNested<String, Integer> table = new TableNested<>();

        table.put("Burr", 1);
        System.out.println(table.get("Burr"));
        table.put("Burr", 2);
        System.out.println(table.get("Burr"));
        table.remove("Burr");
        System.out.println(table.get("Burr"));
    }
}

class TableNested<K, V> {
    private ArrayList<Entry> table = new ArrayList<>();

    public void put (K key, V value) {
        for (Entry entry : table) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        table.add(new Entry(key, value));
    }

    public V get (K key) {
        for (Entry entry : table) {/**/
            if (entry.key == key) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        for (Entry entry : table) {
            if (entry.key == key) {
                table.remove(entry);
                return;
            }
        }
    }

    private class Entry {
        K key;
        V value;

        Entry (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
