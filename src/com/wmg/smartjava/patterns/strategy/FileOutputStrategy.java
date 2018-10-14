package com.wmg.smartjava.patterns.strategy;

import java.io.File;
import java.util.List;

public interface FileOutputStrategy {

    void generateSummaryOutput(List<File> fileList);
}
