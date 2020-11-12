package com.bridgelabz.IPLLeagueAnalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadIPLData {
    public <E> List<E> loadIPLData(String csvFilePath, Class csvClass, List<E> iplList) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplList = csvBuilder.getCsvFileList(reader,csvClass);
            return iplList;
        } catch (CSVBuilderException csvBuilderException){
            csvBuilderException.getMessage();
        }
        return iplList;
    }
}
