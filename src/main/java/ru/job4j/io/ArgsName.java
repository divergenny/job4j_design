package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String rslt = values.get(key);
        if (null == rslt) {
            throw new IllegalArgumentException("Not exist.");
        } else {
            return rslt;
        }
    }

    private void parse(String[] args) {
        for (var value : args) {
            String[] data = value.split("=");
            if (data.length == 2) {
                values.put(normalizeForm(data[0]), normalizeForm(data[1]));
            } else {
                throw new IllegalArgumentException("Data is not fit.");
            }
        }
    }

    public String normalizeForm(String data) {
        return data.toCharArray()[0] == '-' ? data.replaceFirst("-", "") : data;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
