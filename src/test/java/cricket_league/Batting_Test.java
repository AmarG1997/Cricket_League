package cricket_league;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class Batting_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";

    @Test
    public void givenBattingCsvFile_shouldReturnCsvFileData() {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_FILE_PATH);
        System.out.println(noOfRecords);
        Assert.assertEquals(101,noOfRecords);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnTopBattingAverages() {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBattingCsv>list = cricketAnalyzer.getTopBattingAverages();
        Assert.assertTrue(list.get(0).toString().contains("MS Dhoni"));
        Assert.assertEquals(83.2,list.get(0).avg,0);
        Assert.assertEquals(0.0,list.get(100).avg,0);
    }
}
