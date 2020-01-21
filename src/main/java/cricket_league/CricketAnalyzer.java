package cricket_league;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<CricketLeagueDao> list = new ArrayList<>();

    public DataFile dataFile;

    public enum DataFile{ BATTING,BOWLING}

    public int loadDataFile(String csvFilePath,Class className) throws CricketAnalyzerException {
        LoadCSVDataFile loadCsvDataFile = new LoadCSVDataFile();
        list = loadCsvDataFile.loadDataFile(className,csvFilePath);
        return list.size();
    }

    public List getSorting(DataSorting.sorting fields,DataFile file) throws CricketAnalyzerException{
        if (list.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        DataSorting dataSorting = new DataSorting();
        Comparator<CricketLeagueDao> comparator = dataSorting.getComparator(fields,file);
        list = list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return list;
    }

}