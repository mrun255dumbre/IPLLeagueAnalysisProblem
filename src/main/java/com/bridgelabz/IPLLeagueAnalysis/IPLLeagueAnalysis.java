package com.bridgelabz.IPLLeagueAnalysis;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPLLeagueAnalysis {
    List<BattingAnalysisCSV> battingAnalysisCSVList;
    List<BowlingAnalysisCSV> bowlingAnalysisCSVList;
    Sort sort = new Sort();

    public int loadBattingAnalysis(String csvFilePath) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            battingAnalysisCSVList = csvBuilder.getCsvFileList(reader,BattingAnalysisCSV.class);
            return battingAnalysisCSVList.size();
        } catch (CSVBuilderException csvBuilderException) {
            csvBuilderException.getMessage();
        }
        return battingAnalysisCSVList.size();
    }

    public int loadBowlingAnalysis(String csvFilePath) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            bowlingAnalysisCSVList = csvBuilder.getCsvFileList(reader,BowlingAnalysisCSV.class);
            return bowlingAnalysisCSVList.size();
        } catch (CSVBuilderException csvBuilderException){
            csvBuilderException.getMessage();
        }
        return battingAnalysisCSVList.size();
    }

    public String getAverageWiseSortedIPLBattingData(String filePath) throws IOException {
        loadBattingAnalysis(filePath);
        Comparator<BattingAnalysisCSV> battingAnalysisComparatorComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.average);
        this.sort.sort(battingAnalysisCSVList,battingAnalysisComparatorComparator);
        String sortedBattingAnalysisAsJSON = new Gson().toJson(battingAnalysisCSVList);
        return sortedBattingAnalysisAsJSON;
    }
}
