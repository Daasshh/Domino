package com.csf.zagreba.hashmaprealization;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class OwnHashMapRealization<Key, Value> implements Map<Key, Value>{

    private ArrayList<MyEntry<Key, Value>>[] table;

    private final int defaultSize = 10;
    private int size = 0;

    public static void main(String[] args) {

    }

    private static class MyEntry<Key, Value> implements Entry<Key, Value> {
        Key key;
        Value value;

        public MyEntry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Key getKey() {
            return this.key;
        }

        @Override
        public Value getValue() {
            return this.value;
        }

        @Override
        public Value setValue(Value value) {
            Value temp = this.value;
            this.value = value;
            return temp;
        }
    }

    private int indexFor(Object key) {
        return key.hashCode() % table.length;
    }

    public OwnHashMapRealization() {
        table = new ArrayList[defaultSize];
        for (int i = 0; i < defaultSize; i++) {
            table[i] = new ArrayList<>();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        return table[index].stream()
                .anyMatch((e) -> e.getKey().equals(key));
    }

    @Override
    public boolean containsValue(Object value) {
        requireNonNull(value);

        return Arrays.stream(table)
                .anyMatch((l) -> l.stream()
                        .anyMatch((e) -> e.getValue().equals(value)));
    }

    @Override
    public Value get(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        for (MyEntry<Key, Value> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Value put(Key key, Value value) {
        requireNonNull(key);
        requireNonNull(value);

        int index = indexFor(key);

        for (MyEntry<Key, Value> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                Value oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        table[index].add(new MyEntry<Key, Value>(key, value));
        size++;
        return null;
    }

    @Override
    public Value remove(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        for (MyEntry<Key, Value> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                Value oldValue = entry.getValue();
                table[index].remove(entry);
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> m) {
        requireNonNull(m);

        if (!m.isEmpty()) {
            m.keySet().stream()
                    .forEach((k) -> put(k, m.get(k)));
        }
    }

    @Override
    public void clear() {
        Arrays.stream(table)
                .forEach((l) -> l.clear());
        size = 0;
    }

    @Override
    public Set<Key> keySet() {
        Set<Key> set = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> e.getKey()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return set;
    }

    @Override
    public Collection<Value> values() {
        Collection<Value> collection = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> e.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));
        return collection;
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {
        Set<Entry<Key, Value>> set = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> new AbstractMap.SimpleEntry<Key, Value>(e.getKey(), e.getValue())))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return set;
    }

    @Override
    public String toString() {
        Set<Entry<Key, Value>> set = entrySet();

        String result = "{";
        result += set.stream()
                .map((e) -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", "));
        result += "}";

        return result;
    }

}

