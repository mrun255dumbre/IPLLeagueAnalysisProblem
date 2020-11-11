package com.bridgelabz.IPLLeagueAnalysis;

import com.opencsv.bean.CsvBindByName;

public class BattingAnalysisCSV {

    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column ="NO", required = true)
    public int no;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highestScore;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column ="BF", required = true)
    public int bowlsFaced;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getBoundaryCount(){
        return fours + sixes;
    }

    @Override
    public String toString() {
        return "BattingAnalysisCSV{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", no=" + no +
                ", runs=" + runs +
                ", highestScore='" + highestScore + '\'' +
                ", average=" + average +
                ", bowlsFaced=" + bowlsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}
