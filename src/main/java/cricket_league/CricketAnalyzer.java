package cricket_league;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<CricketLeagueDao> list = new ArrayList<>();

    public DataFile dataFile;

    public enum DataFile{BATTING,BOWLING}

    public CricketAnalyzer(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    public int loadDataFile(String csvFilePath, Class className) throws CricketAnalyzerException {
        LoadCSVDataFile loadCsvDataFile = new LoadCSVDataFile();
        list = loadCsvDataFile.loadDataFile(className,csvFilePath);
        return list.size();
    }

    public List getSorting(DataSorting.sorting fields,DataFile file) throws CricketAnalyzerException{
        if (list.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        Comparator<CricketLeagueDao> comparator = new DataSorting().getComparator(fields,file);
        List list1 = list.stream()
                .sorted(comparator)
                .map(cricketLeagueDao -> cricketLeagueDao.getCricketDTO(dataFile))
                .collect(Collectors.toList());
        return list1;
    }
}