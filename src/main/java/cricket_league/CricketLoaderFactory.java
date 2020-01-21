package cricket_league;

import java.util.List;

public class CricketLoaderFactory {

    public static <E> List getLoadDataFile(String csvFilePath, CricketAnalyzer.DataFile dataFile) throws CricketAnalyzerException {
        if (dataFile.equals(CricketAnalyzer.DataFile.BATTING))
            return new LoadCSVDataFile().loadDataFile(IPLBatting.class,csvFilePath);
        if (dataFile.equals(CricketAnalyzer.DataFile.BOWLING))
            return new LoadCSVDataFile().loadDataFile(IPLBowling.class,csvFilePath);
        throw new CricketAnalyzerException("No Such File", CricketAnalyzerException.ExceptionType.NO_SUCH_FILE);
    }
}
