package com.wmg.smartjava.patterns.strategy;

import java.io.File;
import java.util.Arrays;

public class TestStrategyPattern {

    public static void main(String[] args) {

        FileGenerationTypeContext context = new FileGenerationTypeContext();
        context.setFileOutputStrategy(new TextOutputStrategy());

        File file1 = new File("test1");
        File file2 = new File("test2");

        context.createFileOutput(Arrays.asList(file1, file2));

    }
}
