package cricket_league;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<IPLBattingCsv> iplBattingCsvList = new ArrayList<>();


    public int loadCSvDataFile(String csvFilePath) throws CricketAnalyzerException {
        LoadCsvDataFile loadCsvDataFile = new LoadCsvDataFile();
        iplBattingCsvList = loadCsvDataFile.loadBattingDataFile(csvFilePath);
        return iplBattingCsvList.size();
    }

    public List getSorting(DataSorting.sorting fields) throws CricketAnalyzerException{
        if (iplBattingCsvList.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        DataSorting dataSorting = new DataSorting();
        Comparator<IPLBattingCsv> comparator = dataSorting.getComparator(fields);
        iplBattingCsvList = iplBattingCsvList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        System.out.println(iplBattingCsvList);
        return iplBattingCsvList;
    }

}