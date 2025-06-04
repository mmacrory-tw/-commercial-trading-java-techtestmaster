package com.global.commtech.test.anagramfinder;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
class AnagramFinderServiceIntegrationTest {

    @Test
    void shouldPrintAnagramGroupsFromFile(CapturedOutput output) throws IOException {
        //given
        String testFilePath = "src/test/resources/example1.txt";

        AnagramFinderService service = new AnagramFinderService(new InputFileProcessor());

        // when
        service.findAnagrams(testFilePath);

        // then
        String out = output.getOut();

        assertThat(out).contains("abc,bac,cba");
        assertThat(out).contains("fun,unf");
        assertThat(out).contains("hello");
    }
}
