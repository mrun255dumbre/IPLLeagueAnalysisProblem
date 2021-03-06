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
    String sortedIPLBowlingData;

    @Before
    public void setUp() throws Exception {
        iplLeagueAnalysis = new IPLLeagueAnalysis();
    }

    @Test
    public void givenBattingAnalysisData_ShouldSortedOnAverage() throws IOException {
        sortedIPLBattingData = iplLeagueAnalysis.getAverageWiseSortedIPLBattingData(BATTING_CSV_FILE_PATH);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
        Assert.assertEquals(0,battingAnalysisCSV[0].average,0.0);
        Assert.assertEquals(83.2,battingAnalysisCSV[100].average, 0.0);
    }

    @Test
    public void givenBattingAnalysisData_ShouldSortedOnStrikeRate() throws  IOException {
        sortedIPLBattingData = iplLeagueAnalysis.getHighestStrikeRate(BATTING_CSV_FILE_PATH);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
        Assert.assertEquals("Ishant Sharma",battingAnalysisCSV[100].player);
        Assert.assertEquals("Andre Russell",battingAnalysisCSV[99].player);
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

    @Test
    public void givenBattingAnalysisData_WhenGreatAverageWithBestStrikeRate_ShouldReturnResult () throws IOException{
        sortedIPLBattingData = iplLeagueAnalysis.getGreatAverageWithBestStrikeRateBattingData(BATTING_CSV_FILE_PATH);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
        Assert.assertEquals("Ishant Sharma",battingAnalysisCSV[100].player);
    }

    @Test
    public void givenBattingAnalysisData_WhenMaximumRunWithBestAverage_ShouldReturnResult () throws IOException{
        sortedIPLBattingData = iplLeagueAnalysis.getMaximumRunWithBestAverageBattingData(BATTING_CSV_FILE_PATH);
        BattingAnalysisCSV[] battingAnalysisCSV = new Gson().fromJson(sortedIPLBattingData, BattingAnalysisCSV[].class);
        Assert.assertEquals("MS Dhoni",battingAnalysisCSV[100].player);
    }

    @Test
    public void givenBowlingAnalysisData_WhenTopBowlingAverage_ShouldReturnResult () throws IOException{
        sortedIPLBowlingData = iplLeagueAnalysis.getTopBowlingAverageBowlingData(BOWLING_CSV_FILE_PATH);
        BowlingAnalysisCSV[] bowlingAnalysisCSV = new Gson().fromJson(sortedIPLBowlingData, BowlingAnalysisCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",bowlingAnalysisCSV[98].player);
    }

    @Test
    public void givenBowlingAnalysisData_WhenTopStrikingRate_ShouldReturnResult () throws IOException{
        sortedIPLBowlingData = iplLeagueAnalysis.getTopStrikingRateBowlingData(BOWLING_CSV_FILE_PATH);
        BowlingAnalysisCSV[] bowlingAnalysisCSV = new Gson().fromJson(sortedIPLBowlingData, BowlingAnalysisCSV[].class);
        Assert.assertEquals(120,bowlingAnalysisCSV[bowlingAnalysisCSV.length-1].strikeRate,0.0);
    }

    @Test
    public void givenBowlingAnalysisData_WhenBestEconomyRate_ShouldReturnResult () throws IOException{
        sortedIPLBowlingData = iplLeagueAnalysis.getBestEconomyRateBowlingData(BOWLING_CSV_FILE_PATH);
        BowlingAnalysisCSV[] bowlingAnalysisCSV = new Gson().fromJson(sortedIPLBowlingData, BowlingAnalysisCSV[].class);
        Assert.assertEquals("Ben Cutting",bowlingAnalysisCSV[bowlingAnalysisCSV.length-1].player);
    }

    @Test
    public void givenBowlingAnalysisData_WhenBestStrikeRateWith5wAnd4w_ShouldReturnResult () throws IOException{
        sortedIPLBowlingData = iplLeagueAnalysis.getBestStrikingRateWith5wAnd4wBowlingData(BOWLING_CSV_FILE_PATH);
        BowlingAnalysisCSV[] bowlingAnalysisCSV = new Gson().fromJson(sortedIPLBowlingData, BowlingAnalysisCSV[].class);
        Assert.assertEquals("Lasith Malinga",bowlingAnalysisCSV[bowlingAnalysisCSV.length-1].player);
    }

    @Test
    public void givenBowlingAnalysisData_WhenGreatBowlingaverageWithBestStrikeRate_ShouldReturnResult () throws IOException{
        sortedIPLBowlingData = iplLeagueAnalysis.getGreatAverageWithBestStrikingRateBowlingData(BOWLING_CSV_FILE_PATH);
        BowlingAnalysisCSV[] bowlingAnalysisCSV = new Gson().fromJson(sortedIPLBowlingData, BowlingAnalysisCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",bowlingAnalysisCSV[bowlingAnalysisCSV.length-1].player);
    }
}
