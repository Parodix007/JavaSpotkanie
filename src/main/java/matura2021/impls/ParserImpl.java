package matura2021.impls;

import matura2021.interfaces.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    @Override
    public List<String> parseFileContentToList(String content) {
        return Arrays.stream(content.split("\n")).collect(Collectors.toList());
    }
}
