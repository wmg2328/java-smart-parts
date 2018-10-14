package com.wmg.smartjava.patterns.strategy;

import java.io.File;
import java.util.List;

public class CsvOutputStrategy implements FileOutputStrategy {

    @Override
    public void generateSummaryOutput(List<File> fileList) {
        fileList.forEach(file -> System.out.println(String.format("File %s is converted as csv", file.getName())));
    }
}
