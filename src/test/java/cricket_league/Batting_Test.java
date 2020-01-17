package cricket_league;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;


public class Batting_Test {

    private static final String IPL_2019_BATTING_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.csv";
    private static final String IPL_2019_BATTING_WRONG_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanData.txt";
    private static final String IPL_2019_BATTING_WRONG_HEADER_FILE_PATH="/home/admin1/IdeaProjects/Cricket_League/src/test/resources/BatsmanWithWrongHeader.csv";

    @Test
    public void givenBattingCsvFile_shouldReturnCsvFileData() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        int noOfRecords = cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_FILE_PATH);
        System.out.println(noOfRecords);
        Assert.assertEquals(101,noOfRecords);
    }

    @Test
    public void givenBattingWrongCsvFile_shouldThrowException()  {
        try{
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CricketAnalyzerException.class);
        cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_WRONG_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenBattingWrongCsvFileHeader_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CricketAnalyzerException.class);
            cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_WRONG_HEADER_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA,e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenBattingCsvFile_shouldReturnTopBattingAverages() throws CricketAnalyzerException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer();
        cricketAnalyzer.loadBattingDataFile(IPL_2019_BATTING_FILE_PATH);
        List<IPLBattingCsv> list = cricketAnalyzer.getTopBattingAverages();
        Assert.assertTrue(list.get(0).toString().contains("MS Dhoni"));
        Assert.assertEquals(83.2,list.get(0).avg,0);
        Assert.assertEquals(0.0,list.get(100).avg,0);
    }
}
