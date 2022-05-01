package com.zbackendu.main;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    private static double power(double number) {
        boolean pivot = false, potega = true;
        while (!pivot) {
            potega = scanner.hasNext();

            if (scanner.hasNext("tak")) {
                pivot = true;
            } else if (scanner.hasNext("nie")) {
                potega = false;
                pivot = true;
            } else {
                System.out.println("Wpisz prawidłowo tak/nie");
            }
        }
        number = number * number;
        return potega ? number : 1.0;
    }

    private static double calcSwitch(char funkcja, double wynik, double _wynik, double number) {
        switch (funkcja) {
            case '+': {
                wynik = _wynik + number;
                System.out.println("Wynik: " + (wynik));
                break;
            }
            case '-': {
                wynik = _wynik - number;
                System.out.println("Wynik: " + (wynik));
                break;
            }
            case '*': {
                wynik = _wynik * number;
                System.out.println("Wynik: " + (wynik));
                break;
            }
            case '/': {
                wynik = _wynik / number;
                System.out.println("Wynik: " + (wynik));
                if (number == 0.0) {
                    System.out.println("Nie dzielimy przez 0!");
                    break;
                }
                break;
            }
        }
        return wynik;
    }
    public static void main(String[] args) {

        System.out.println("Kalkulator v1.1");
        double liczba1, liczba2, liczba3, wynik1 = 0.0, wynik2 = 0.0;
        char funkcja, funkcja2;

        System.out.println("\n\nObsługiwane funkcje:");
        System.out.println("Aby wykonać funkcję dodawania - wpisz +");
        System.out.println("Aby wykonać funkcję odejmowania - wpisz -");
        System.out.println("Aby wykonać funkcję mnożenia - wpisz *");
        System.out.println("Aby wykonać funkcję dzielenia - wpisz /");

        System.out.println("Wybierz 3 liczby na których wykonywane będą działania - pamiętaj, że wpisane przez Ciebie liczby mają przypisaną kolejność i działania wykonywane będą według schematu [l1 - x1 - l2 - x2 - l3](w miejsciu x1 i x2 wybrane działanie)!");

        System.out.println("\nWpisz pierwszą liczbę:");

        liczba1 = scanner.nextDouble();

        System.out.println("Czy liczba ma zostać podniesiona do potęgi? Jeśli tak - wpisz 'tak', jeśli nie - wpisz 'nie'");

        liczba1 = power(liczba1);

        System.out.println("\nWybierz pierwszą obsługiwaną funkcję:");
        scanner.next();
        funkcja = scanner.next().charAt(0);

        while (funkcja != '+' && funkcja != '-' && funkcja != '*' && funkcja != '/') {
            System.out.println("Funkcja nieprawidłowa! Wybierz obsługiwaną funkcję:");
            funkcja = scanner.next().charAt(0);
        }


        System.out.println("\nWpisz drugą liczbę:");

        liczba2 = scanner.nextDouble();

        System.out.println("Czy liczba ma zostać podniesiona do potęgi? Jeśli tak - wpisz 'tak', jeśli nie - wpisz 'nie'");

        liczba2 = power(liczba2);

        System.out.println("\nWybierz drugą obsługiwaną funkcję:");

        funkcja2 = scanner.next().charAt(0);

        while (funkcja2 != '+' && funkcja2 != '-' && funkcja2 != '*' && funkcja2 != '/') {

            funkcja2 = scanner.next().charAt(0);
            System.out.println("Funkcja nieprawidłowa! Wybierz obsługiwaną funkcję:");

        }
        System.out.println("\nWpisz trzecią liczbę:");

        liczba3 = scanner.nextDouble();

        System.out.println("Czy liczba ma zostać podniesiona do potęgi? Jeśli tak - wpisz 'tak', jeśli nie - wpisz 'nie'");

        liczba3 = power(liczba3);

        double v = calcSwitch(funkcja, wynik1, wynik2, liczba3);
        double v1 = calcSwitch(funkcja2, wynik1, wynik2, liczba2);
    }
}