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

    public int loadBattingDataFile(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplBattingCsvList = csvBuilder.getCSVFileList(reader,IPLBattingCsv.class);
            return iplBattingCsvList.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List getTopBattingAverages() {
        iplBattingCsvList = iplBattingCsvList.stream()
                .sorted((data1,data2) -> data1.avg - data2.avg > 0 ? -1 : 1)
                .collect(Collectors.toList());
        return iplBattingCsvList;

    }
}
