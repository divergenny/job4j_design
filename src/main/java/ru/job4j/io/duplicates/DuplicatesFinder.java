package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class DuplicatesFinder {

    public void showDuplicates(List<FileProperty> duplicates) {
        if (duplicates.size() > 0) {
            for (var duplicate : duplicates) {
                System.out.println("Duplicate path: " + duplicate.getName());
            }
        } else {
            System.out.println("Duplicates not found");
        }
    }

    public static void main(String[] args) throws IOException {
        DuplicatesFinder duplicatesFinder = new DuplicatesFinder();
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        duplicatesFinder.showDuplicates(duplicatesVisitor.getListOfDuplicates());
    }
}
