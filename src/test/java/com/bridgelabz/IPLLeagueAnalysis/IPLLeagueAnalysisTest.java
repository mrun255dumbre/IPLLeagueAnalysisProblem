package com.bridgelabz.IPLLeagueAnalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class IPLLeagueAnalysisTest {
    IPLLeagueAnalysis iplLeagueAnalysis;
    private static final String BATTING_CSV_FILE_PATH = "C:\\Users\\Pranav\\IdeaProjects\\IPLLeagueAnalysisProblem\\batting.csv";
    private static final String BOWLING_CSV_FILE_PATH = "C:\\Users\\Pranav\\IdeaProjects\\IPLLeagueAnalysisProblem\\bowling.csv";

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
}
