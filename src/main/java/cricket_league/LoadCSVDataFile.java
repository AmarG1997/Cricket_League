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
import java.util.stream.StreamSupport;

public class LoadCSVDataFile {

    List<CricketLeagueDao> fileData = new ArrayList<>();

    public<E>  List loadDataFile(Class IPLClass ,String csvFilePath) throws CricketAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> IPLdataList = csvBuilder.getCSVFileList(reader,IPLClass);
            if (IPLClass.getName().equals("cricket_league.IPLBatting")){
                StreamSupport.stream(IPLdataList.spliterator(),false)
                        .map(IPLBatting.class::cast)
                        .forEach(CricketCSV -> fileData.add(new CricketLeagueDao(CricketCSV)));
            }
            if (IPLClass.getName().equals("cricket_league.IPLBowling")){
                StreamSupport.stream(IPLdataList.spliterator(),false)
                        .map(IPLBowling.class::cast)
                        .forEach(CricketCSV -> fileData.add(new CricketLeagueDao(CricketCSV)));
            }
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
        return fileData;
    }
}