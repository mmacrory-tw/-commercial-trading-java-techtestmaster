package com.global.commtech.test.anagramfinder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AnagramFinderService {

    public void findAnagrams(String inputFilePath) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            List<String> group = new ArrayList<>();
            int currentLength = -1;

            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                if (word.isEmpty()) continue;

                int len = word.length();
                if (currentLength == -1) {
                    currentLength = len;
                }
                if (len != currentLength) {
                    printAnagrams(group);
                    group.clear();
                    currentLength = len;
                }
                group.add(word);
            }

            if (!group.isEmpty()) {
                printAnagrams(group);
            }
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
