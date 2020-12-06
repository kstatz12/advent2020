package dev.kstatz12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Input extends AbstractInput {

    @Override
    public List<String> getFileLines(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            List<String> lines = new ArrayList<>();

            String line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            return lines;
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
