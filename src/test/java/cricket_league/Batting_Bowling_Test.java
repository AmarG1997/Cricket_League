package cricket_league;

import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Batting_Bowling_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";
    private static final String IPL_2019_BOWLING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.csv";

    @Test
    public void whenGivenBattingAndBowlingFileData_shouldReturnBestBatsman_Bowler() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BATTING);
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH, IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.BATTING_BOWLING_AVG, CricketAnalyzer.DataFile.BATTING_BOWLING);
        Assert.assertEquals("MS Dhoni",list.get(0).player.trim());
        Assert.assertEquals("Harpreet Brar",list.get(98).player.trim());
    }
}
