package ru.job4j.generic;
import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();
    int id = 0;

    @Override
    public void add(T model) {
        mem.put(String.valueOf(id++), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (Integer.parseInt(id) <= this.id) {
            mem.put(id, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (Integer.parseInt(id) <= this.id) {
            mem.remove(id);
            this.id--;
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
