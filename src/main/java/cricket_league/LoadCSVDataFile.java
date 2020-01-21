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

public class LoadCSVDataFile {

    List<CricketLeagueDao> fileData = new ArrayList<>();

    public <E> List loadDataFile(String csvFilePath) throws CricketAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            if (csvFilePath.equals("/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv")){
                fileData = csvBuilder.getCSVFileList(reader, IPLBatting.class);
                return fileData;
            }
            if (csvFilePath.equals("/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.csv"))
                fileData = csvBuilder.getCSVFileList(reader, IPLBowling.class);
            return fileData;
        } catch (IOException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            throw new CricketAnalyzerException(e.getMessage(), e.type.name());
        } catch (RuntimeException e) {
            throw new CricketAnalyzerException(e.getMessage(),
                    CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }

}
