package matura2021.interfaces;

import java.util.Optional;

public interface FileReader {
    Optional<String> readFileToString(String filePath);
}
