package com.bridgelabz.IPLLeagueAnalysis;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public <E> String returnJsonFile(List<E> iplList,Comparator<E> comparator ){
        this.sort(iplList,comparator);
        String sortedIPLData=new Gson().toJson(iplList);
        return sortedIPLData;
    }

    public <E> void sort(List<E> csvList, Comparator<E> comparator) {
        for (int i = 0; i < csvList.size() - 1; i++) {
            for (int j = 0; j < csvList.size() - i - 1; j++) {
                E ipl = csvList.get(j);
                E iplNext = csvList.get(j + 1);
                if (comparator.compare(ipl, iplNext) > 0) {
                    csvList.set(j, iplNext);
                    csvList.set(j + 1, ipl);
                }
            }
        }
    }
}
