package com.bridgelabz.IPLLeagueAnalysis;

import com.opencsv.bean.CsvBindByName;

public class BowlingAnalysisCSV {

    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double overs;

    @CsvBindByName(column = "Wkts", required = true)
    public String wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlingInInnings;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "Econ", required = true)
    public double economyRate;

    @CsvBindByName(column = "SR", required = true)
    public String strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicketsInInnings;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWicketsInInnings;

    @Override
    public String toString() {
        return "BowlingAnalysisCSV{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", overs=" + overs +
                ", wickets='" + wickets + '\'' +
                ", bestBowlingInInnings=" + bestBowlingInInnings +
                ", average=" + average +
                ", economyRate=" + economyRate +
                ", strikeRate='" + strikeRate + '\'' +
                ", fourWicketsInInnings=" + fourWicketsInInnings +
                ", fiveWicketsInInnings=" + fiveWicketsInInnings +
                '}';
    }
}
