package cricket_league;

import java.util.Map;

public class BowlerAdapter extends CricketAdapter {

    @Override
    public <E> Map<String, CricketLeagueDao> loadDataFile(String... csvFilePath) throws CricketAnalyzerException {
        Map<String,CricketLeagueDao> cricketLeagueDaoMap = super.loadDataFile(IPLBowling.class,csvFilePath[0]);
        return cricketLeagueDaoMap;
    }
}
