package cricket_league;

import java.util.Map;

public class BatsmanAdapter extends CricketAdapter {

    @Override
    public <E> Map<String, CricketLeagueDao> loadDataFile(String... csvFilePath) throws CricketAnalyzerException {
        Map<String,CricketLeagueDao> cricketLeagueDaoMap = super.loadDataFile(IPLBatting.class,csvFilePath[0]);
        return cricketLeagueDaoMap;
    }
}
