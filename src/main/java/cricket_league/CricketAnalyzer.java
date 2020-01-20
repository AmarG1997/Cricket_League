package cricket_league;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<IPLBatting> iplBattingList = new ArrayList<>();
    List<IPLBowling> iplBowlinglist = new ArrayList<>();

    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
        LoadCSVDataFile loadCsvDataFile = new LoadCSVDataFile();
        iplBattingList = loadCsvDataFile.loadBattingDataFile(csvFilePath);
        return iplBattingList.size();
    }

    public int loadBowlingDataFile(String csvFilePath) throws CricketAnalyzerException {
        LoadCSVDataFile loadCsvDataFile = new LoadCSVDataFile();
        iplBowlinglist = loadCsvDataFile.loadBowlingDataFile(csvFilePath);
        System.out.println(iplBowlinglist.size());
        return iplBowlinglist.size();
    }

    public List getSorting(DataSorting.sorting fields) throws CricketAnalyzerException{
        if (iplBattingList.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        DataSorting dataSorting = new DataSorting();
        Comparator<IPLBatting> comparator = dataSorting.getComparator(fields);
        iplBattingList = iplBattingList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return iplBattingList;
    }

}