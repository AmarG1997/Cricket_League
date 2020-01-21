package cricket_league;

public class CricketLeagueDao {

    //POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
    //POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,ND

    public int pos;
    public String player;
    public int matches;
    public int inns;
    public int notOut;
    public int runs;
    public int highScore;
    public double average;
    public int ballFaced;
    public double strikeRate;
    public int centuries;
    public int fifties;
    public int fours;
    public int sixs;
    public double over;
    public int wickets;
    public int bestBowlingIndex;
    public double economy;
    public int fourWickets;
    public int fiveWickets;

    public CricketLeagueDao(IPLBatting iplBatting) {
        pos = iplBatting.pos;
        player = iplBatting.player;
        matches = iplBatting.matches;
        inns = iplBatting.inns;
        notOut = iplBatting.notOut;
        runs = iplBatting.runs;
        highScore = iplBatting.highScore;
        average = iplBatting.avg;
        ballFaced = iplBatting.ballFaced;
        strikeRate = iplBatting.strikeRate;
        centuries = iplBatting.centuries;
        fifties = iplBatting.halfCenturies;
        fours = iplBatting.fours;
        sixs = iplBatting.sixes;
    }

    public CricketLeagueDao(IPLBowling iplBowling) {
        pos = iplBowling.pos;
        player = iplBowling.player;
        matches = iplBowling.matches;
        inns = iplBowling.innings;
        over = iplBowling.over;
        runs = iplBowling.runs;
        wickets = iplBowling.wickets;
        bestBowlingIndex = iplBowling.bestBowlingIndex;
        average = iplBowling.average;
        economy = iplBowling.economy;
        strikeRate = iplBowling.strikeRate;
        fourWickets = iplBowling.fourWickets;
        fiveWickets = iplBowling.fiveWickets;
    }

    @Override
    public String toString() {
        return "CricketLeagueDao{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore=" + highScore +
                ", average=" + average +
                ", ballFaced=" + ballFaced +
                ", strikeRate=" + strikeRate +
                ", centuries=" + centuries +
                ", fifties=" + fifties +
                ", fours=" + fours +
                ", sixs=" + sixs +
                ", over=" + over +
                ", wickets=" + wickets +
                ", bestBowlingIndex=" + bestBowlingIndex +
                ", economy=" + economy +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }

    public Object getCricketDTO(CricketAnalyzer.DataFile file) {
        if (file.equals(CricketAnalyzer.DataFile.BATTING))
            return new IPLBatting(pos, player, matches, inns, notOut, runs, highScore, average, ballFaced, strikeRate, centuries, fifties, fours, sixs);
        return new IPLBowling(pos, player, matches, inns, over, runs, wickets, bestBowlingIndex, average, economy, strikeRate, fourWickets, fiveWickets);
    }
}
