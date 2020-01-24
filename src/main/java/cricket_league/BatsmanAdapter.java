package cricket_league;

import csvBuilder.CSVBuilderFactory;
import csvBuilder.CsvBuilderException;
import csvBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatsmanAdapter extends DataLoader {

    Map<String,CricketLeagueDao>cricketLeagueDaoMap=new HashMap<>();

    @Override
    public <E> Map<String, CricketLeagueDao> loadDataFile(String... csvFilePath) throws CricketAnalyzerException, IOException, CsvBuilderException {
            Map<String,CricketLeagueDao> cricketLeagueDaoMap = super.loadDataFile(IPLBatting.class,csvFilePath[0]);
            if (csvFilePath.length==2)
                 this.loadDataFile1(cricketLeagueDaoMap,csvFilePath[1]);
            return cricketLeagueDaoMap;

    }

    public int loadDataFile1(Map<String, CricketLeagueDao> cricketLeagueDaoMap, String csvFilePath) throws IOException, CsvBuilderException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IPLBowling> IPLdataList = csvBuilder.getCSVFileList(reader,IPLBowling.class);
            StreamSupport.stream(IPLdataList.spliterator(),false)
                        .filter(IPLBowling-> cricketLeagueDaoMap.get(IPLBowling.player)!=null)
                        .forEach(IPLBowling -> {cricketLeagueDaoMap.get(IPLBowling.player).
                                baverage=IPLBowling.average;
                        cricketLeagueDaoMap.get(IPLBowling.player).wickets=IPLBowling.wickets;});
            return this.cricketLeagueDaoMap.size();
            }

        }

    }