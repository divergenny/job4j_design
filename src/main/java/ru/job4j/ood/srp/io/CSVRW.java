package ru.job4j.ood.srp.io;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVRW implements ReadWriteFile {
    public List<List<String>> read(String pathToCsvFile) {
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(pathToCsvFile));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    public void write(String path, String nameOfFile, String extensionOfFile, String data) {
        File outputFile = new File(path
                + "/" + nameOfFile
                + "." + extensionOfFile);
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            pw.println(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
