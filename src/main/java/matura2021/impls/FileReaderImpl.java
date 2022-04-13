package matura2021.impls;

import matura2021.interfaces.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class FileReaderImpl implements FileReader {
    @Override
    public Optional<String> readFileToString(String filePath) {
        Optional<InputStream> resourceAsStream = Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(filePath));
        return resourceAsStream.map(content -> {
            try {
                return Optional.of(new String(content.readAllBytes(), StandardCharsets.UTF_8));
            } catch (final IOException e) {
                e.printStackTrace();
                return Optional.<String>empty();
            }
        }).orElseGet(Optional::empty);
    }
}
