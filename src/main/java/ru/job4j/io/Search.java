package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validateArguments(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName()
                .endsWith(args[1]))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validateArguments(String[] args) {
        if (args.length == 2) {
            File file = new File(args[0]);
            if (!file.exists()) {
                throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
            }
            if (!file.isDirectory()) {
                throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
            }
        } else {
            throw new IllegalArgumentException("Something went wrong, check your arguments. "
                    + "Usage java -jar search.jar ROOT_FOLDER.");
        }
    }
}
