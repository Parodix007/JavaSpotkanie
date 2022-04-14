package matura2021;

import matura2021.impls.FileReaderImpl;
import matura2021.impls.ParserImpl;
import matura2021.models.Tasks;

public class Matura2021 {
    public static void main(String[] args) {
        Tasks tasks = Tasks.tasksFrom(new FileReaderImpl(), new ParserImpl(), "matura2021/galerie_przyklad.txt");
        tasks.zadanie1();
        tasks.zadani2();
        tasks.zadani3();
    }
}
