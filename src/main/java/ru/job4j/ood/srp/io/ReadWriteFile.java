package ru.job4j.ood.srp.io;

import java.util.List;

public interface ReadWriteFile {
    public List<List<String>> read(String path);

    public void write(String path, String nameOfFile, String extensionOfFile, String data);
}
