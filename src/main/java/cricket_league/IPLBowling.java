package cricket_league;

import com.opencsv.bean.CsvBindByName;

public class IPLBowling {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double over;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlingIndex;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "Econ", required = true)
    public double economy;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    @CsvBindByName(column = "ND")
    public String nullData;

    public IPLBowling(int pos, String player, int matches, int inns, double over,
                      int runs, int wickets, int bestBowlingIndex, double average,
                      double economy, double strikeRate, int fourWickets, int fiveWickets) {
        this.pos=pos;
        this.player=player;
        this.matches=matches;
        this.innings=inns;
        this.over=over;
        this.runs=runs;
        this.wickets=wickets;
        this.bestBowlingIndex=bestBowlingIndex;
        this.average=average;
        this.economy=economy;
        this.strikeRate=strikeRate;
        this.fiveWickets=fiveWickets;
        this.fourWickets=fourWickets;
    }

    @Override
    public String toString() {
        return "IPLBowling{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", over=" + over +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bestBowlingIndex=" + bestBowlingIndex +
                ", average=" + average +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                ", nullData='" + nullData + '\'' +
                '}';
    }

    public IPLBowling() {
    }
}
