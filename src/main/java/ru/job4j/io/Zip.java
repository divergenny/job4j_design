package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<File> sources, File target) {
        for (File file : sources) {
            packSingleFile(file, target);
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * -d - directory - которую мы хотим архивировать
     * -e - exclude - исключить файлы *.xml
     * -o - output - во что мы архивируем.
     *
     * @param args -d = directory, -e = exclude, -o = output
     */
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        ArgsName zip = ArgsName.of(new String[]{args[0], args[1], args[2]});
        if (null == zip.get("d") || null == zip.get("e") || null == zip.get("o")) {
            throw new IllegalArgumentException("Something went wrong, check your arguments. "
                    + "java -jar pack.jar -d=directory -e=type of exclude file -o=output folder name.");
        }
        Path start = Paths.get(zip.get("d"));
        ArrayList<Path> excludePath = new ArrayList<>();
        ArrayList<Path> pathsToArchive = new ArrayList<>();
        try {
            Search.search(start, p -> p.toFile().getName()
                            .endsWith(zip.get("e")))
                    .forEach(path -> excludePath.add(path));
            Search.search(start, p -> p.toFile().getName()
                            .endsWith(""))
                    .forEach(path -> pathsToArchive.add(path));


        } catch (IOException e) {
            e.printStackTrace();
        }
        pathsToArchive.removeAll(excludePath);
        ArrayList<File> filesToArchive = new ArrayList<>();
        pathsToArchive.forEach(Path -> filesToArchive.add(Path.toFile()));
        File target = new File(zip.get("o"));
        packFiles(filesToArchive, target);
    }
}
