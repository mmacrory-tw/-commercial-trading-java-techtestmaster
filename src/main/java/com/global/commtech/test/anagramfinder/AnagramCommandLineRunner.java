package com.global.commtech.test.anagramfinder;

import java.io.File;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class AnagramCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        final String filePath = args[0];
        final File file = new File(filePath);
        Assert.isTrue(file.exists(), filePath + " Does not exist");

        AnagramFinderService anagramFinder = new AnagramFinderService();
        anagramFinder.findAnagrams(filePath);

    }
}
