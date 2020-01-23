package cricket_league;

import csvBuilder.CsvBuilderException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    Map<String ,CricketLeagueDao> list = null;

    public DataFile dataFile;

    public enum DataFile{BATTING,BOWLING,BATTING_BOWLING}

    public CricketAnalyzer(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    public int loadDataFile(String... csvFilePath) throws CricketAnalyzerException, IOException, CsvBuilderException {
        list=new CricketLoaderFactory().getLoadDataFile(dataFile,csvFilePath);
        return list.size();
    }

    public List getSorting(DataSorting.sorting fields,DataFile file) throws CricketAnalyzerException{
        if (list.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        Comparator<CricketLeagueDao> comparator = new DataSorting().getComparator(fields,file);
        List list1 = list.values().stream()
                .sorted(comparator)
                .map(cricketLeagueDao -> cricketLeagueDao.getCricketDTO(file))
                .collect(Collectors.toList());
        return list1;
    }
}
