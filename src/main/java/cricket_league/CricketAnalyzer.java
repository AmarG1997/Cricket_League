package cricket_league;

import csvBuilder.CSVBuilderFactory;
import csvBuilder.CsvBuilderException;
import csvBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<IPLBattingCsv> iplBattingCsvList = new ArrayList<>();

    public int loadBattingDataFile(String csvFilePath) throws CricketAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplBattingCsvList = csvBuilder.getCSVFileList(reader, IPLBattingCsv.class);
            return iplBattingCsvList.size();
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }

    public List getTopBattingAverages() throws CricketAnalyzerException{
        if (iplBattingCsvList.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        iplBattingCsvList = iplBattingCsvList.stream()
                .sorted((data1,data2) -> data1.avg - data2.avg > 0 ? -1 : 1)
                .collect(Collectors.toList());
        return iplBattingCsvList;

    }

    public List getTopBattingStrikeRate() throws CricketAnalyzerException {
        if (iplBattingCsvList.size()==0){
            throw new CricketAnalyzerException("Null pointer Exception",
                    CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION);
        }
        iplBattingCsvList = iplBattingCsvList.stream()
                .sorted((data1,data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1)
                .collect(Collectors.toList());
        return iplBattingCsvList;
    }
}
