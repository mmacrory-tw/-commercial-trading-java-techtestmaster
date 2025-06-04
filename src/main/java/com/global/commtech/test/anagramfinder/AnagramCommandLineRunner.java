package com.global.commtech.test.anagramfinder;

import java.io.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final AnagramFinderService anagramFinder;

    public AnagramCommandLineRunner(AnagramFinderService anagramFinder) {
        this.anagramFinder = anagramFinder;
    }

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        final String filePath = args[0];
        final File file = new File(filePath);
        Assert.isTrue(file.exists(), filePath + " Does not exist");

        anagramFinder.findAnagrams(filePath);

    }
}
