package cricket_league;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DataSorting {

    public enum sorting {
        AVG, STRIKE_RATE, MOST_6s_4s, MOST_6s_4s_STRIKERATE, BEST_AVG_WITH_STRIKE_RATE, MAX_RUNS, MAX_RUNS_WITH_BEST_AVG,
        ECONOMY, MOST_STRIKE_RATE_4W_5W, MOST_4W_5W, MOST_STRIKERATE_WITH_AVERAGE, MAX_WICKETS_WITH_BEST_BOWLING_AVG, MOST_WKTS,
        BATTING_BOWLING_AVG, BAVG;
    }

    Map<sorting, Comparator<CricketLeagueDao>> map = new HashMap<>();

    public Comparator getComparator(sorting field, CricketAnalyzer.DataFile file) {
        if (file.equals(CricketAnalyzer.DataFile.BATTING)) {
            map.put(sorting.AVG, (data1, data2) -> data1.Baverage - data2.Baverage > 0 ? -1 : 1);
            map.put(sorting.STRIKE_RATE, (data1, data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1);
            map.put(sorting.MOST_6s_4s, (data1, data2) -> (data2.sixs * 6 + data2.fours * 4) - (data1.sixs * 6 + data1.fours * 4));
            map.put(sorting.MOST_6s_4s_STRIKERATE, map.get(sorting.MOST_6s_4s).thenComparing(map.get(sorting.STRIKE_RATE)));
            map.put(sorting.BEST_AVG_WITH_STRIKE_RATE, map.get(sorting.AVG).thenComparing((data1, data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1));
            map.put(sorting.MAX_RUNS, (data1, data2) -> data1.runs - data2.runs > 0 ? -1 : 1);
            map.put(sorting.MAX_RUNS_WITH_BEST_AVG, map.get(sorting.MAX_RUNS).thenComparing(map.get(sorting.AVG)));
            return map.get(field);
        }
        if (file.equals(CricketAnalyzer.DataFile.BOWLING)) {
            map.put(sorting.BAVG, (data1, data2) -> data1.baverage - data2.baverage > 0 ? -1 : 1);
            map.put(sorting.STRIKE_RATE, (data1, data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1);
            map.put(sorting.ECONOMY, (data1, data2) -> data1.economy - data2.economy > 0 ? -1 : 1);
            map.put(sorting.MOST_WKTS, (data1, data2) -> data1.wickets - data2.wickets > 0 ? -1 : 1);
            map.put(sorting.MOST_4W_5W, (data1, data2) -> (data1.fiveWickets * 5 + data1.fourWickets * 4) - (data2.fiveWickets * 5 + data2.fourWickets * 4));
            map.put(sorting.MOST_STRIKE_RATE_4W_5W, map.get(sorting.MOST_4W_5W).thenComparing(map.get(sorting.STRIKE_RATE)).reversed());
            map.put(sorting.MOST_STRIKERATE_WITH_AVERAGE, map.get(sorting.BAVG).thenComparing(map.get(sorting.STRIKE_RATE)));
            map.put(sorting.MAX_WICKETS_WITH_BEST_BOWLING_AVG, map.get(sorting.MOST_WKTS).thenComparing(map.get(sorting.BAVG)));
            return map.get(field);
        }
        if (file.equals(CricketAnalyzer.DataFile.BATTING_BOWLING)) {
            map.put(sorting.AVG, (data1, data2) -> data1.Baverage - data2.Baverage > 0 ? -1 : 1);
            map.put(sorting.BAVG, (data1, data2) -> data1.baverage - data2.baverage > 0 ? -1 : 1);
            map.put(sorting.BATTING_BOWLING_AVG, map.get(sorting.AVG).thenComparing(map.get(sorting.AVG)));
            return map.get(field);
        }
        return null;
    }
}
