package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private String pathToCSV;
    private String pathToOUT;

    public void setPathToCSV(String pathToCSV) {
        this.pathToCSV = pathToCSV;
    }

    public void setPathToOUT(String pathToOUT) {
        this.pathToOUT = pathToOUT;
    }

    public String getPathToCSV() {
        return pathToCSV;
    }

    public String getPathToOUT() {
        return pathToOUT;
    }

    public void write(String data) throws IOException {
        if ("stdout".equals(getPathToOUT())) {
            System.out.println(data);
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPathToOUT()))) {
                writer.write(data);
            }
        }
    }

    private void validate(ArgsName argsName) {
        String[] parameters = new String[]{"path", "delimiter", "out", "filter"};
        for (String value : parameters) {
            argsName.get(value);
        }
        setPathToCSV(argsName.get("path"));
        setPathToOUT(argsName.get("out"));
    }

    public static void handle(ArgsName argsName) throws Exception {
        CSVReader reader = new CSVReader();
        reader.validate(argsName);
        StringBuilder data = new StringBuilder();
        Scanner scanner = new Scanner(new File(reader.getPathToCSV()));
        String line = scanner.nextLine();
        String[] header = line.split(";");
        String[] keys = argsName.get("filter").split(",");
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < header.length; j++) {
                if (keys[i].equals(header[j])) {
                    indexes.add(j);
                }
            }
        }
        indexes.forEach(v -> data.append(header[v]).append(";"));
        data.replace(data.length() - 1, data.length(), "");
        data.append(System.lineSeparator());
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            String[] values = line.split(";");
            indexes.forEach(v -> data.append(values[v]).append(";"));
            data.replace(data.length() - 1, data.length(), "");
            data.append(System.lineSeparator());
        }
        scanner.close();
        reader.write(data.toString());
    }

    public static void main(String[] args) throws Exception {
        handle(ArgsName.of(args, 4, "Something went wrong!!!"));
    }
}
