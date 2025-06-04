package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
public class InputFileProcessor {

    public Map<Integer, File> groupWordsByLength(String inputFilePath) throws IOException {
        Map<Integer, File> tempFiles = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                if (word.isEmpty()) continue;

                int len = word.length();

                File tempFile = tempFiles.computeIfAbsent(len, l -> {
                    try {
                        return File.createTempFile("words_len_" + l + "_", ".tmp");
                    } catch (IOException e) {
                        throw new UncheckedIOException("Unable to create temp file", e);
                    }
                });

                try (FileWriter fw = new FileWriter(tempFile, true);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(word);
                    bw.newLine();
                }
            }
        }
        return tempFiles;
    }
}
