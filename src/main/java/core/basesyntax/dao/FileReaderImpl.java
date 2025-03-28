package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String DEFAULT_INPUT_FILE = "reportToRead.csv";

    @Override
    public List<String> readFile(String fileName) {
        String filePath = getFilePath(fileName == null || fileName.isBlank()
                ? DEFAULT_INPUT_FILE : fileName);
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file " + filePath, e);
        }
        return lines;
    }

    private String getFilePath(String fileName) {
        Path filePath = Path.of(fileName);
        if (filePath.isAbsolute() || Files.exists(filePath)) {
            return filePath.toString();
        }

        var resource = ClassLoader.getSystemResource(fileName);
        if (resource == null) {
            throw new RuntimeException("Resource not found: " + fileName);
        }
        return Path.of(resource.getPath()).toString();
    }
}
