package cricket_league;

import org.junit.Assert;
import org.junit.Test;


public class Batting_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";

    @Test
    public void givenBattingCsvFile_shouldReturnCsvFileData() {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_FILE_PATH);
        Assert.assertEquals(101,noOfRecords);
    }
}
