package com.bridgelabz.IPLLeagueAnalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class IPLLeagueAnalysisTest {
    IPLLeagueAnalysis iplLeagueAnalysis;
    private static final String BATTING_CSV_FILE_PATH = "C:\\Users\\Pranav\\IdeaProjects\\IPLLeagueAnalysisProblem\\batting.csv";
    private static final String BOWLING_CSV_FILE_PATH = "C:\\Users\\Pranav\\IdeaProjects\\IPLLeagueAnalysisProblem\\bowling.csv";
    String sortedIPLBattingData;

    @Before
    public void setUp() throws Exception {
        iplLeagueAnalysis = new IPLLeagueAnalysis();
    }

    @Test
    public void givenBattingAnalysisCsvFile_ShouldReturnCorrectRecords() throws IOException {
        int numOfRecords = iplLeagueAnalysis.loadBattingAnalysis(BATTING_CSV_FILE_PATH);
        Assert.assertEquals(101,numOfRecords);
    }

    @Test
    public void givenBowlingAnalysisCsvFile_ShouldReturnCorrectRecords() throws IOException {
        int numOfRecords = iplLeagueAnalysis.loadBowlingAnalysis(BOWLING_CSV_FILE_PATH);
        Assert.assertEquals(99,numOfRecords);
    }

    @Test
    public void givenBattingAnalysisData_ShouldSortedOnAverage() {
        try {
            sortedIPLBattingData = iplLeagueAnalysis.getAverageWiseSortedIPLBattingData(BATTING_CSV_FILE_PATH);
            BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
            Assert.assertEquals(0,battingAnalysisCSV[0].average,0.0);
            Assert.assertEquals(83.2,battingAnalysisCSV[100].average, 0.0);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void givenBattingAnalysisData_ShouldSortedOnStrikeRate() {
        try {
            sortedIPLBattingData = iplLeagueAnalysis.getHighestStrikeRate(BATTING_CSV_FILE_PATH);
            BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
            Assert.assertEquals("Ishant Sharma",battingAnalysisCSV[100].player);
            Assert.assertEquals("Andre Russell",battingAnalysisCSV[99].player);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void givenBattingAnalysisData_WhenMax6sAnd4s_ShouldReturnResult () throws IOException{
        List sortedIPLBattingData = iplLeagueAnalysis.getMaximumSixesAndFoursBattingData(BATTING_CSV_FILE_PATH);
        String sixes = (String) sortedIPLBattingData.get(0);
        String fours = (String) sortedIPLBattingData.get(1);
        BattingAnalysisCSV[] battingAnalysis = new Gson().fromJson(sixes, BattingAnalysisCSV[].class);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(fours, BattingAnalysisCSV[].class);
        Assert.assertEquals("Andre Russell",battingAnalysis[battingAnalysis.length-1].player);
        Assert.assertEquals("Shikhar Dhawan",battingAnalysisCSV[battingAnalysisCSV.length-1].player);
    }

    @Test
    public void givenBattingAnalysisData_WhenStrikeRateMax6sAnd4s_ShouldReturnResult () throws IOException{
        sortedIPLBattingData = iplLeagueAnalysis.getHighestStrikeRateWithMax6sand4s(BATTING_CSV_FILE_PATH);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
        Assert.assertEquals("Andre Russell",battingAnalysisCSV[100].player);
    }
}
