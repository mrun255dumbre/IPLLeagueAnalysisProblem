package com.bridgelabz.IPLLeagueAnalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPLLeagueAnalysis {
    List<BattingAnalysisCSV> battingAnalysisCSVList;
    List<BowlingAnalysisCSV> bowlingAnalysisCSVList;
    IPLDataSort iplDataSort = new IPLDataSort();
    LoadIPLData loadIPLData = new LoadIPLData();

    public String getAverageWiseSortedIPLBattingData(String filePath) throws IOException {
        Comparator<BattingAnalysisCSV> battingAnalysisComparatorComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.average);
        return this.iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList),battingAnalysisComparatorComparator);
    }

    public String getHighestStrikeRate(String filePath) throws IOException {
        Comparator<BattingAnalysisCSV> battingAnalysisComparator = Comparator.comparing(battingAnalysisCSV -> battingAnalysisCSV.strikeRate);
        return this.iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList),battingAnalysisComparator);
    }

    public List<String> getMaximumSixesAndFoursBattingData(String filePath) throws IOException {
        List<String> maxSixesAndFours = new ArrayList<>();
        Comparator<BattingAnalysisCSV> battingAnalysisComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.sixes);
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(battingAnalysis -> battingAnalysis.fours);
        maxSixesAndFours.add(iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList), battingAnalysisComparator));
        maxSixesAndFours.add(iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList), battingAnalysisCSVComparator));
        return maxSixesAndFours;
    }

    public String getHighestStrikeRateWithMax6sand4s(String filePath) throws IOException {
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(BattingAnalysisCSV::getBoundaryCount).thenComparing(BattingAnalysisCSV::getStrikeRate);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList), battingAnalysisCSVComparator);
    }

    public String getGreatAverageWithBestStrikeRateBattingData(String filePath) throws IOException {
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(BattingAnalysisCSV::getStrikeRate).thenComparing(BattingAnalysisCSV::getAverage);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList), battingAnalysisCSVComparator);
    }

    public String getMaximumRunWithBestAverageBattingData(String filePath) throws IOException {
        Comparator<BattingAnalysisCSV> battingAnalysisCSVComparator = Comparator.comparing(BattingAnalysisCSV::getAverage).thenComparing(BattingAnalysisCSV::getRuns);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BattingAnalysisCSV.class,battingAnalysisCSVList), battingAnalysisCSVComparator);
    }

    public String getTopBowlingAverageBowlingData(String filePath) throws IOException {
        Comparator<BowlingAnalysisCSV> bowlingAnalysisCSVComparator = Comparator.comparing(bowlingAnalysisCSV -> bowlingAnalysisCSV.average );
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BowlingAnalysisCSV.class,bowlingAnalysisCSVList), bowlingAnalysisCSVComparator);
    }

    public String getTopStrikingRateBowlingData(String filePath) throws IOException {
        Comparator<BowlingAnalysisCSV> bowlingAnalysisCSVComparator = Comparator.comparing(bowlingAnalysisCSV -> bowlingAnalysisCSV.strikeRate);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BowlingAnalysisCSV.class,bowlingAnalysisCSVList), bowlingAnalysisCSVComparator);
    }

    public String getBestEconomyRateBowlingData(String filePath) throws IOException {
        Comparator<BowlingAnalysisCSV> bowlingAnalysisCSVComparator = Comparator.comparing(bowlingAnalysisCSV -> bowlingAnalysisCSV.economyRate);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BowlingAnalysisCSV.class,bowlingAnalysisCSVList), bowlingAnalysisCSVComparator);
    }

    public String getBestStrikingRateWith5wAnd4wBowlingData(String filePath) throws IOException {
        Comparator<BowlingAnalysisCSV> bowlingAnalysisCSVComparator = Comparator.comparing(BowlingAnalysisCSV::getWicketInInnings).thenComparing(BowlingAnalysisCSV::getStrikeRate);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BowlingAnalysisCSV.class,bowlingAnalysisCSVList), bowlingAnalysisCSVComparator);
    }

    public String getGreatAverageWithBestStrikingRateBowlingData(String filePath) throws IOException {
        Comparator<BowlingAnalysisCSV> bowlingAnalysisCSVComparator = Comparator.comparing(BowlingAnalysisCSV::getStrikeRate).thenComparing(BowlingAnalysisCSV::getAverage);
        return iplDataSort.returnJsonFile(loadIPLData.loadIPLData(filePath,BowlingAnalysisCSV.class,bowlingAnalysisCSVList), bowlingAnalysisCSVComparator);
    }
}
