package com.global.commtech.test.anagramfinder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramFinderService {

    public void findAnagrams(String inputFilePath) throws IOException {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        Map<Integer, File> groupedFiles = inputFileProcessor.groupWordsByLength(inputFilePath);

        for (Map.Entry<Integer, File> entry : groupedFiles.entrySet()) {
            File file = entry.getValue();

            List<String> words = Files.readAllLines(file.toPath());

            printAnagrams(words);

            file.delete();
        }
    }

    public void printAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String sorted = sortChars(word);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }

        for (List<String> group : map.values()) {
            System.out.println(String.join(",", group));
        }
    }

    private String sortChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
