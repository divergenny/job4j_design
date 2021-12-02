package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    /**
     * With the jar file and the necessary parameters,
     * you can safely archive multiple files and exclude
     * one type of files that do not need to be archived.
     * Using directory, I create relative path to files.
     *
     * @param sources   List of files that archive.
     * @param target    Name of file with extension zip, that will as an output.
     * @param directory Directory that we want to archive.
     */
    public static void packFiles(List<Path> sources, File target, Path directory) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path file : sources) {
                zip.putNextEntry(new ZipEntry(directory.relativize(file).toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method archives a single file.
     *
     * @param source Path to file that need to archive.
     * @param target Name of file with extension zip, that will as an output.
     */
    public static void packSingleFile(Path source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * With the jar file and the necessary parameters,
     * you can safely archive files and exclude
     * one type of files that do not need to be archived.
     * -d - directory - которую мы хотим архивировать
     * -e - exclude - исключить файлы *.xml
     * -o - output - во что мы архивируем.
     * First of all, we check the arguments that come to us using Args name.
     * After that, we create a list of paths and use the Search method
     * to find the necessary files and exclude unnecessary ones.
     * After that, we pass the necessary parameters to the packFiles method.
     *
     * @param args -d = directory, -e = exclude, -o = output.zip
     */
    public static void main(String[] args) {
        ArgsName zip = ArgsName.of(args, 3,
                "Please check all parameters again, "
                        + "the right way is using it as: "
                        + System.lineSeparator()
                        + "java -jar pack.jar -d=c:\\project\\job4j\\ -e=class -o=project.zip"
                        + System.lineSeparator()
                        + "-d - directory - которую мы хотим архивировать"
                        + System.lineSeparator()
                        + "-e - exclude - исключить файлы *.xml"
                        + System.lineSeparator()
                        + "-o - output - во что мы архивируем.");
        Path directory = Paths.get(zip.get("d"));
        List<Path> pathsToArchive = null;
        try {
            pathsToArchive = Search.search(directory,
                    path -> !path.toFile().getName().endsWith(zip.get("e")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File target = new File(zip.get("o"));
        packFiles(pathsToArchive, target, directory);
        System.out.println("Successfully archived");
    }
}
