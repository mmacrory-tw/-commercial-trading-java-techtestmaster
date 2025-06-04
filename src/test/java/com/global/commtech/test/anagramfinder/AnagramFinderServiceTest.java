package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class AnagramFinderServiceTest {

    @InjectMocks
    AnagramFinderService mockService;

    @Test
    void testPrintAnagrams_printsGroupedAnagrams() {
        List<String> words = List.of("cab", "abc", "star", "rats");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        mockService.printAnagrams(words);

        String output = outputStream.toString().trim();

        assertThat(output).contains("cab,abc");
        assertThat(output).contains("star,rats");
    }

}
