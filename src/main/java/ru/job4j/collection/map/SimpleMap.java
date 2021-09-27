package ru.job4j.collection.map;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key));
        if (table[index] != null) {
            return false;
        } else {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
    }

    private int hash(Object key) {
        int h;
        if (key != null) {
            h = key.hashCode();
            return h ^ (h >>> 16);
        }
        return 0;
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] oldTable = table;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> keySetValue : oldTable) {
            if (keySetValue != null) {
                put(keySetValue.key, keySetValue.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key));
        if (table[index] == null || !table[index].key.equals(key)) {
            return null;
        }
        return table[index].value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = indexFor(hash(key));
        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final MapEntry<K, V>[] itrTable = table;
            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                int pointNext = point;
                boolean result = false;
                while (pointNext < itrTable.length) {
                    if (itrTable[pointNext++] != null) {
                        result = true;
                        point = pointNext - 1;
                        break;
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return itrTable[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
