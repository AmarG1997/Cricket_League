
package cricket_league;

import csvBuilder.CsvBuilderException;

import java.io.IOException;
import java.util.Map;

public class CricketLoaderFactory {

    public static Map<String, CricketLeagueDao> getLoadDataFile(CricketAnalyzer.DataFile dataFile, String... csvFilePath) throws CricketAnalyzerException, IOException, CsvBuilderException {
        if (dataFile.equals(CricketAnalyzer.DataFile.BATTING))
            return new BatsmanAdapter().loadDataFile(csvFilePath);
        if (dataFile.equals(CricketAnalyzer.DataFile.BOWLING))
            return new BowlerAdapter().loadDataFile(IPLBowling.class,csvFilePath[0]);
        throw new CricketAnalyzerException("No Such File", CricketAnalyzerException.ExceptionType.NO_SUCH_FILE);
    }
}