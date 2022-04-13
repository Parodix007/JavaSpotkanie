package matura2021.models;

import matura2021.interfaces.FileReader;
import matura2021.interfaces.Parser;

import java.util.Optional;

public class Tasks {

    private final FileReader fileReader;

    private final Parser parser;

    private Tasks(FileReader fileReader, Parser parser) {
        this.fileReader = fileReader;
        this.parser = parser;
    }

    public static Tasks tasksFrom(FileReader fileReader, Parser parser) {
        return new Tasks(fileReader, parser);
    }

    public void test() {
        Optional<String> s = fileReader.readFileToString("matura2021/galerie_przyklad.txt");
        System.out.println(s.get());
    }
}
