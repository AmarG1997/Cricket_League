package cricket_league;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class Batting_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";
    private static final String IPL_2019_BATTING_WRONG_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.txt";
    private static final String IPL_2019_BATTING_WRONG_HEADER_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanWithWrongHeader.csv";

    @Test
    public void givenBattingCsvFile_shouldReturnCsvFileData() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        Assert.assertEquals(101,noOfRecords);
    }

    @Test
    public void givenBattingWrongCsvFileType_shouldThrowException()  {
        try{
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_WRONG_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenBattingWrongCsvFileHeader_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            cricketAnalyzer.loadDataFile(IPL_2019_BATTING_WRONG_HEADER_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA,e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenBattingCsvFile_shouldReturnTopBattingAverages() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.AVG, CricketAnalyzer.DataFile.BATTING);
        Assert.assertTrue(list.get(0).toString().contains("MS Dhoni"));
        Assert.assertEquals(83.2,list.get(0).avg,0);
        Assert.assertEquals(0.0,list.get(100).avg,0);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnTopBattingStrikingGRates() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.STRIKE_RATE, CricketAnalyzer.DataFile.BATTING);
        Assert.assertEquals(333.33,list.get(0).strikeRate,0);
        Assert.assertEquals(63.15,list.get(100).strikeRate,0);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnMost6sand4s() throws CricketAnalyzerException{
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.MOST_6s_4s, CricketAnalyzer.DataFile.BATTING);
        Assert.assertEquals("Andre Russell",list.get(0).player);
        Assert.assertEquals("Tim Southee",list.get(100).player);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnMost6sand4sWithStrikeRates() throws CricketAnalyzerException{
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.MOST_6s_4s_STRIKERATE, CricketAnalyzer.DataFile.BATTING);
        Assert.assertEquals("Andre Russell",list.get(0).player);
        Assert.assertEquals("Shakib Al Hasan",list.get(100).player);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnGreatAvgWithBestStrikeRate() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting>list = cricketAnalyzer.getSorting(DataSorting.sorting.BEST_AVG_WITH_STRIKE_RATE, CricketAnalyzer.DataFile.BATTING);
        Assert.assertEquals("MS Dhoni",list.get(0).player);
        Assert.assertEquals("Tim Southee",list.get(100).player);
    }

    @Test
    public void givenBattingCsvFile_shouldReturnGreatRunsWithBestAverage() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBatting> list = cricketAnalyzer.getSorting(DataSorting.sorting.MAX_RUNS_WITH_BEST_AVG, CricketAnalyzer.DataFile.BATTING);
        Assert.assertEquals("David Warner",list.get(0).player.trim());
        Assert.assertEquals("Tim Southee",list.get(100).player);
    }

}
