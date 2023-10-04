package ru.job4j.cache;

/**
 * класс описывает реализацию кэша
 *
 * @author divergenny
 * @version 1.0
 * @since 04.10.2023
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */
public class Emulator {
    private final DirFileCache dir;

    public Emulator(String dirFileCache) {
        dir = new DirFileCache(dirFileCache);
    }

    /**
     * загружаем данные из файла
     *
     * @param key по ключу
     */
    public void load(String key) {
        dir.load(key);
    }

    /**
     * добавляем в кэш
     *
     * @param key по ключу
     * @return на выходе данные в кэше
     */
    public String getCacheData(String key) {
        return dir.get(key);
    }

    /**
     * демонстрация
     *
     * @param args точка входа, данные
     *             указываем директорию
     *             добавляем в кэш
     *             читаем из кэша
     */
    public static void main(String[] args) {
        Emulator emulator = new Emulator("data/2.4. Garbage Collection"
                + "/2.4.4. Типы ссылок и коллекции на soft weak ссылках"
                + "/1. Реализация кеша на SoftReference/");
        emulator.load("Names.txt");
        String data = emulator.getCacheData("Names.txt");
        System.out.println(data);
    }
}
