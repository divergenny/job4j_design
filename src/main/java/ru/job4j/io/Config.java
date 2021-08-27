package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            bufferedReader.lines().forEach(line -> {
                if (!line.startsWith("#") && !line.isEmpty() && !line.contains("//")) {
                    String[] parts = line.split("=");
                    if (parts.length < 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                        throw new UnsupportedOperationException();
                    }
                    values.put(parts[0], parts[1]);
                }
            });
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
