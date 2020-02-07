package cricket_league;

import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MockTest {
    private static final String IPL_2019_BATTING_FILE_PATH="/home/administrator/Code/Cricket_League-master/src/test/resources/BatsmanData.csv";
    private static final String IPL_2019_BOWLING_FILE_PATH="/home/administrator/Code/Cricket_League-master/src/test/resources/BowlerData.csv";
    @Mock
    LoadDataFile loadDataFile;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Map<String, CricketLeagueDao> cricketLeagueDaoMap=new HashMap<>();

    @Test
    public void givenBattingCsvFile_shouldReturnCsvFileData() throws  IOException, CsvBuilderException {
        cricketLeagueDaoMap.put("A", new CricketLeagueDao());
        cricketLeagueDaoMap.put("B", new CricketLeagueDao());
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BATTING,loadDataFile);
        try {
            when(loadDataFile.getCsvData(CricketAnalyzer.DataFile.BATTING,IPL_2019_BATTING_FILE_PATH)).thenReturn(cricketLeagueDaoMap);
            int noOfRecords = cricketAnalyzer.loadDataFile(IPL_2019_BATTING_FILE_PATH);
            Assert.assertEquals(2,noOfRecords);
        }catch (CricketAnalyzerException e){

        }
    }

    @Test
    public void givenBowlingCsvFile_shouldReturnCsvFileData() throws  IOException, CsvBuilderException {
        cricketLeagueDaoMap.put("A", new CricketLeagueDao());
        cricketLeagueDaoMap.put("B", new CricketLeagueDao());
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BOWLING,loadDataFile);
        try {
            when(loadDataFile.getCsvData(CricketAnalyzer.DataFile.BOWLING,IPL_2019_BOWLING_FILE_PATH)).thenReturn(cricketLeagueDaoMap);
            int noOfRecords = cricketAnalyzer.loadDataFile(IPL_2019_BOWLING_FILE_PATH);
            Assert.assertEquals(2,noOfRecords);
        }catch (CricketAnalyzerException e){
        }
    }

    @Test
    public void givenNullCsvFile_shouldthrowException() throws  IOException, CsvBuilderException {
        cricketLeagueDaoMap.put("A", new CricketLeagueDao());
        cricketLeagueDaoMap.put("B", new CricketLeagueDao());
        CricketAnalyzer cricketAnalyzer = new CricketAnalyzer(CricketAnalyzer.DataFile.BATTING,loadDataFile);
        try {
            when(loadDataFile.getCsvData(CricketAnalyzer.DataFile.BATTING,null)).thenThrow(new CricketAnalyzerException("Null Value", CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION));
            int noOfRecords = cricketAnalyzer.loadDataFile(null);
        }catch (CricketAnalyzerException e){
            Assert.assertEquals(CricketAnalyzerException.ExceptionType.NULL_POINTER_EXCEPTION, e.type);
        }
    }

}
