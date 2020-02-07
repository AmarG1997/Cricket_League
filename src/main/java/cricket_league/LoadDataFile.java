package cricket_league;

import csvBuilder.CsvBuilderException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoadDataFile {
    public Map<String, CricketLeagueDao> getCsvData(CricketAnalyzer.DataFile file , String... csvFilePath) throws CricketAnalyzerException, IOException, CsvBuilderException {
        return new CricketLoaderFactory().getLoadDataFile(file,csvFilePath);
    }
}
