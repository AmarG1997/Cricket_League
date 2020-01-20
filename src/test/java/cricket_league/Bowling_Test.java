package cricket_league;

import org.junit.Assert;
import org.junit.Test;

public class Bowling_Test {

    private static final String IPL_2019_BOWLING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.csv";

    @Test
    public void givenBowlingCsvFile_shouldReturnCsvFileData() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadBowlingDataFile(IPL_2019_BOWLING_FILE_PATH);
        Assert.assertEquals(99,noOfRecords);
    }
}
