package cricket_league;

import java.util.Comparator;

public class ComparatorParameters {

    public enum BattingParameter implements SortingParameters{
        AVERAGE{
            public Comparator getComparator() {
                return Comparator.<IPLBattingDAO, Double>comparing(census -> census.avg).reversed();
            }
        },
        STRIKERATE{
            public Comparator getComparator() {
                return Comparator.<IPLBattingDAO, Double>comparing(census -> census.strikeRate).reversed();
            }
        }
    }
}
