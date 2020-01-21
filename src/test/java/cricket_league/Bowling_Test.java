package cricket_league;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Bowling_Test {

    private static final String IPL_2019_BOWLING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.csv";
    private static final String IPL_2019_BOWLING_WRONG_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerData.txt";
    private static final String IPL_2019_BOWLING_WRONG_HEADER_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BowlerDataWithWrongHeader.csv";

    @Test
    public void givenBowlingCsvFile_shouldReturnCsvFileData() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        Assert.assertEquals(99,noOfRecords);
    }

    @Test
    public void givenBowlingWrongCsvFileType_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_WRONG_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenBowlingWrongCsvFileHeader_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_WRONG_HEADER_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA,e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnTopBowlingAverages() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.AVG, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals(166.0,list.get(0).average,0);
        Assert.assertEquals(0.0,list.get(98).average,0);
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnTopStrikeRate() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.STRIKE_RATE, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals(120.0,list.get(0).strikeRate,0);
        Assert.assertEquals(0.0,list.get(98).strikeRate,0);
    }

}
