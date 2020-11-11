package com.bridgelabz.IPLLeagueAnalysis;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return this.returnJsonFile(battingAnalysisCSVList,battingAnalysisComparatorComparator);
    }

    public String getHighestStrikeRate(String filePath) throws IOException {
        loadBattingAnalysis(filePath);
        Comparator<BattingAnalysisCSV> battingAnalysisComparator = Comparator.comparing(battingAnalysisCSV -> battingAnalysisCSV.strikeRate);
        return this.returnJsonFile(battingAnalysisCSVList,battingAnalysisComparator);
    }

    public List<String> getMaximumSixesAndFoursBattingData(String filePath) throws IOException {
        List<String> maxSixesAndFours = new ArrayList<>();
        loadBattingAnalysis(filePath);
        Comparator<BattingAnalysisCSV> battingAnalysisComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.sixes);
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.fours);
        maxSixesAndFours.add(returnJsonFile(battingAnalysisCSVList, battingAnalysisComparator));
        maxSixesAndFours.add(returnJsonFile(battingAnalysisCSVList, battingAnalysisCSVComparator));
        return maxSixesAndFours;
    }

    public String getHighestStrikeRateWithMax6sand4s(String filePath) throws IOException {
        loadBattingAnalysis(filePath);
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(BattingAnalysisCSV::getBoundaryCount).thenComparing(BattingAnalysisCSV::getStrikeRate);
        return returnJsonFile(battingAnalysisCSVList, battingAnalysisCSVComparator);
    }

    public <E> String returnJsonFile(List<E> iplList,Comparator<E> comparator ){
        this.sort.sort(iplList,comparator);
        String sortedIPLData=new Gson().toJson(iplList);
        return sortedIPLData;
    }
}
