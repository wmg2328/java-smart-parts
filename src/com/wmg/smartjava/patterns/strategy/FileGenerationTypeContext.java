package com.wmg.smartjava.patterns.strategy;

import java.io.File;
import java.util.List;

public class FileGenerationTypeContext {

    private FileOutputStrategy fileOutputStrategy;

    public void setFileOutputStrategy(FileOutputStrategy fileOutputStrategy) {
        this.fileOutputStrategy = fileOutputStrategy;
    }

    public void createFileOutput(List<File> files) {
        fileOutputStrategy.generateSummaryOutput(files);
    }
}
