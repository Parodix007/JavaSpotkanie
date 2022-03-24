package com.zbackendu.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(5);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("PODAJ LICZBE: ");
            int i1 = scanner.nextInt();
            input.add(i1);
        }
        int najwieksza = 0;
        for (Integer element : input) {
            if (element > najwieksza) najwieksza = element;
        }
        System.out.println(najwieksza);

        int i = 0;
        while (i < 5) {
            System.out.println("Hello world");
            i = 5;
        }

        do {
            System.out.println("Hello world");
            i = 5;
        } while (i < 5);
    }
}