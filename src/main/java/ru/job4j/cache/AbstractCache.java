package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * класс описывает структуру данных типа кэш
 *
 * @author divergenny
 * @version 1.0
 * Если get() вернет null, то будет NPE. Эту ситуацию надо учесть.
 * В этом случае надо повторно грузить данные.
 * default V getOrDefault(Object key, V defaultValue)
 */
public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * метод описывает добавление в кэш
     *
     * @param key   ключ
     * @param value данные которые кладем в кэш
     */
    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    /**
     * метод описывает добавление в кэш  с валидацией
     *
     * @param key ключ
     * @return на выходе объект в кэше
     * получаем объект в кэше используя метод getOrDefault(), где значение по умолчанию ставим null
     * т.к. при использовании метода get() и при входящем null получим NPE
     * проверяем, есть ли он в памяти, если нет то загружаем его
     * и кладем в кэш
     */
    public final V get(K key) {
        V v = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (null == v) {
            v = load(key);
            put(key, v);
        }
        return v;
    }

    /**
     * метод загрузки данных
     *
     * @param key ключ данных
     * @return данные
     */
    protected abstract V load(K key);

}
