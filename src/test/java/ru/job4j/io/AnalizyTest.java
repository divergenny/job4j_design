package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {
    Analizy analise = new Analizy();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenOneOutputFromFile() throws IOException {
        File source = folder.newFile("sample.csv");
        File target = folder.newFile("result.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analise.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.get(0), is("10:57:01;10:59:01"));
        assertThat(rsl.get(1), is("11:01:02;11:02:02"));
    }

    @Test
    public void whenTwoOutputFromFile() throws IOException {
        File source = folder.newFile("sample.csv");
        File target = folder.newFile("result.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        analise.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.get(0), is("10:57:01;11:02:02"));
    }

    @Test
    public void whenServerNotRunAgain() throws IOException {
        File source = folder.newFile("sample.csv");
        File target = folder.newFile("result.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
        }
        analise.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.get(0), is("10:57:01;error"));
    }
}