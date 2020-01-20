package cricket_league;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DataSorting {

    public enum sorting{
        AVG,STRIKE_RATE,MOST_6s_4s,MOST_6s_4s_STRIKERATE,BEST_AVG_WITH_STRIKE_RATE,MAX_RUNS,MAX_RUNS_WITH_BEST_AVG
    }

    Map<sorting, Comparator<IPLBattingCsv>> map = new HashMap<>();

    public Comparator getComparator(sorting field){
        map.put(sorting.AVG, (data1,data2) -> data1.avg - data2.avg > 0 ? -1 : 1);
        map.put(sorting.STRIKE_RATE,(data1,data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1);
        map.put(sorting.MOST_6s_4s,(data1,data2) -> (data2.sixes*6+data2.fours*4) - (data1.sixes*6 + data1.fours*4));
        map.put(sorting.MOST_6s_4s_STRIKERATE, map.get(sorting.MOST_6s_4s).thenComparing(map.get(sorting.STRIKE_RATE)));
        map.put(sorting.BEST_AVG_WITH_STRIKE_RATE,map.get(sorting.AVG).thenComparing((data1,data2) -> data1.strikeRate - data2.strikeRate > 0 ? -1 : 1));
        map.put(sorting.MAX_RUNS,(data1,data2) -> data1.runs - data2.runs > 0 ? -1 : 1);
        map.put(sorting.MAX_RUNS_WITH_BEST_AVG,map.get(sorting.MAX_RUNS).thenComparing(map.get(sorting.AVG)));
        return map.get(field);
    }
}
