package cricket_league;

import org.junit.Test;

import java.util.List;

public class Batting_Bowling_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";
    private static final String IPL_2019_BOWLING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.csv";

    @Test
    public void whenGivenBattingAndBowlingFileData_shouldReturnBestBatsman_Bowler() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BATTING);
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH,IPL_2019_BOWLING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.AVG, CricketAnalyzer.DataFile.BATTING);
    }
}
