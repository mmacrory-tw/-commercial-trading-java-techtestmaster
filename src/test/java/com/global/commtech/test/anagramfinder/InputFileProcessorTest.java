package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class InputFileProcessorTest {

    @InjectMocks
    InputFileProcessor mockProcessor;

    @Test
    void shouldCreateFileForEachLength() throws IOException {
        //given
        File inputFile = new File("src/test/resources/example1.txt");
        assertThat(inputFile.exists()).isTrue();

        //when
        Map<Integer, File> result = mockProcessor.groupWordsByLength(inputFile.getPath());

        //then
        assertThat(result).containsKey(3);
        assertThat(result).containsKey(5);

        List<String> threeLetterWords = Files.readAllLines(result.get(3).toPath());

        assertThat(threeLetterWords).contains("abc", "fun", "bac", "cba", "fun", "unf");
    }

}
