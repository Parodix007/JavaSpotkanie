package matura2021.models;

import matura2021.interfaces.FileReader;
import matura2021.interfaces.Parser;

import java.util.*;
import java.util.stream.Collectors;

public class Tasks {

    private final FileReader fileReader;

    private final Parser parser;

    private final String filePath;

    private Tasks(FileReader fileReader, Parser parser, String filePath) {
        this.fileReader = fileReader;
        this.parser = parser;
        this.filePath = filePath;
    }

    public static Tasks tasksFrom(FileReader fileReader, Parser parser, String filePath) {
        return new Tasks(fileReader, parser, filePath);
    }

    private List<String> getFileContentParsed() {
        Optional<String> fileContent = fileReader.readFileToString(filePath);
        return fileContent.map(parser::parseFileContentToList).orElseGet(Collections::emptyList);
    }

    public void zadanie1() {
        List<String> fileContentParsed = getFileContentParsed();
        Map<String, Integer> result = new HashMap<>();

        fileContentParsed.forEach(element -> {
            String[] s = element.split(" ");
            result.computeIfPresent(s[0], (key, value) -> value + 1);
            result.putIfAbsent(s[0], 1);
        });
        System.out.println("Zadanie 1: " + result);
    }

    public void zadanie2() {
        List<String> fileContentParsed = getFileContentParsed();
        Map<String, Map<String, Double>> result = new HashMap<>();

        fileContentParsed.forEach(element -> {
            List<String> fullLine = Arrays.stream(element.split(" ")).collect(Collectors.toList());
            List<String> numbers = fullLine.subList(2, fullLine.size());
            numbers.removeAll(numbers.subList(numbers.indexOf("0"), numbers.size()));

            for (int i = 0; i < numbers.size(); i+=2) {
                double size = Double.parseDouble(numbers.get(i)) * Double.parseDouble(numbers.get(i+1));
                result.computeIfPresent(fullLine.get(1), (key, value) -> {
                    value.compute("size", (key1, value1) -> value1+=size);
                    value.compute("all", (key2, value2) -> value2+=1);
                    return value;
                });
                result.computeIfAbsent(fullLine.get(1), key -> {
                    Map<String, Double> map = new HashMap<>();
                    map.put("size", size);
                    map.put("all", 1.0);
                    return map;
                });
            }
        });

        System.out.println("Zadanie 2 a): " + result);

        Optional<Map.Entry<String, Map<String, Double>>> max = result.entrySet().stream().max((first, second) -> (int) (first.getValue().get("size") - second.getValue().get("size")));
        Optional<Map.Entry<String, Map<String, Double>>> min = result.entrySet().stream().min((first, second) -> (int) (first.getValue().get("size") - second.getValue().get("size")));

        System.out.println("Zadanie 2 b): " + max.get() + " " + min.get());
    }

    public void zadanie3() {
        List<String> fileContentParsed = getFileContentParsed();
        Map<String, Set<Double>> result = new HashMap<>();

        fileContentParsed.forEach(element -> {
            List<String> fullLine = Arrays.stream(element.split(" ")).collect(Collectors.toList());
            List<String> numbers = fullLine.subList(2, fullLine.size());
            numbers.removeAll(numbers.subList(numbers.indexOf("0"), numbers.size()));

            for (int i = 0; i < numbers.size(); i+=2) {
                double size = Double.parseDouble(numbers.get(i)) * Double.parseDouble(numbers.get(i+1));
                result.computeIfPresent(fullLine.get(1), (key, value) -> {
                    value.add(size);
                    return value;
                });
                result.computeIfAbsent(fullLine.get(1), key -> {
                    Set<Double> set = new TreeSet<>();
                    set.add(size);
                    return set;
                });
            }
        });

        Optional<Map.Entry<String, Set<Double>>> max = result.entrySet().stream().max(Comparator.comparingInt(stringSetEntry -> stringSetEntry.getValue().size()));
        Optional<Map.Entry<String, Set<Double>>> min = result.entrySet().stream().min(Comparator.comparingInt(stringSetEntry -> stringSetEntry.getValue().size()));

        System.out.println("Zadanie 3: " + max.get().getValue().size() + " " + min.get().getValue().size());
    }
}
