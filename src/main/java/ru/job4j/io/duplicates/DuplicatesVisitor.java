package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Set<FileProperty> setOfUniqueFiles = new HashSet<>();
    List<FileProperty> listOfDuplicates = new ArrayList<>();
    ArrayList<FileProperty> allDuplicates = new ArrayList<>();

    public String getNameOfFile(String path) {
        return path.substring(path.lastIndexOf("\\") + 1);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        int flag = 0;
        String fileName = file.getFileName().toString();
        String filePath = file.toAbsolutePath().toString();
        for (var uniqueFile : setOfUniqueFiles) {
            if (fileName.equals(getNameOfFile(uniqueFile.getName())) && uniqueFile.getSize() == Files.size(file)) {
                listOfDuplicates.add(new FileProperty(Files.size(file), filePath));
                flag = 1;
            }
        }
        if (flag == 0) {
            setOfUniqueFiles.add(new FileProperty(Files.size(file), filePath));
        }
        return super.visitFile(file, attrs);
    }

    public void showDuplicates() {
        if (listOfDuplicates.size() > 0) {
            for (var uniqueFile : setOfUniqueFiles) {
                int flag = 0;
                for (var duplicate : listOfDuplicates) {
                    if (getNameOfFile(uniqueFile.getName()).equals(getNameOfFile(duplicate.getName()))
                            && uniqueFile.getSize() == duplicate.getSize()) {
                        if (flag == 0) {
                            allDuplicates.add(uniqueFile);
                        }
                        allDuplicates.add(duplicate);
                        flag = 1;
                    }
                }
            }
            System.out.println("Duplicates: ");
            for (var duplicate : allDuplicates) {
                System.out.println(duplicate.getName());
            }
        } else {
            System.out.println("Duplicates not found");
        }
    }
}
