package cricket_league;

import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Bowling_Test {

    private static final String IPL_2019_BOWLING_FILE_PATH="/home/administrator/Cricket_League/src/test/resources/BowlerData.csv";
    private static final String IPL_2019_BOWLING_WRONG_FILE_PATH="/home/administrator/Cricket_League/src/test/resources/BowlerData.txt";
    private static final String IPL_2019_BOWLING_WRONG_HEADER_FILE_PATH="/home/administrator/Cricket_League/src/test/resources/BowlerDataWithWrongHeader.csv";

    @Test
    public void givenBowlingCsvFile_shouldReturnCsvFileData() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        int noOfRecords = cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        Assert.assertEquals(99,noOfRecords);
    }

    @Test
    public void givenBowlingWrongCsvFileType_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
            cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_WRONG_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.FILE_PROBLEM,e.type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingWrongCsvFileHeader_shouldThrowException()  {
        try{
            CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
            cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_WRONG_HEADER_FILE_PATH);
        }catch (CricketAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.INCORRECT_FILE_DATA,e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnTopBowlingAverages() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.BAVG, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals(166.0,list.get(0).average,0);
        Assert.assertEquals(0.0,list.get(98).average,0);
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnTopStrikeRate() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.STRIKE_RATE, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals(120.0,list.get(0).strikeRate,0);
        Assert.assertEquals(0.0,list.get(98).strikeRate,0);
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnBestEconomy() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.ECONOMY, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals(13.5,list.get(0).economy,0);
        Assert.assertEquals(4.8,list.get(98).economy,0);
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnBestStrikeRateWith_5w_4w() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.MOST_STRIKE_RATE_4W_5W, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals("Kagiso Rabada",list.get(0).player.trim());
        Assert.assertEquals("Krishnappa Gowtham",list.get(98).player.trim());
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnGreatBowlingAverage_With_StrikeRate() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile( IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.MOST_STRIKERATE_WITH_AVERAGE, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals("Krishnappa Gowtham",list.get(0).player.trim());
        Assert.assertEquals("Barinder Sran",list.get(98).player.trim());
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnMaxWickets_With_BestBowlingaverage() throws CricketAnalyzerException, IOException, CsvBuilderException {
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING);
        cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
        List<IPLBowling> list = cricketAnalyzer.getSorting(DataSorting.sorting.MAX_WICKETS_WITH_BEST_BOWLING_AVG, CricketAnalyzer.DataFile.BOWLING);
        Assert.assertEquals("Imran Tahir",list.get(0).player.trim());
        Assert.assertEquals("Barinder Sran",list.get(98).player.trim());
    }
}