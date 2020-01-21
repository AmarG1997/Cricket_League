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
    public int over;
    public int wickets;
    public int bestBowlingIndex;
    public double economy;
    public int fourWickets;
    public int fiveWickets;

    public CricketLeagueDao(IPLBatting iplBatting) {
        iplBatting.pos=pos;
        iplBatting.player=player;
        iplBatting.matches=matches;
        iplBatting.inns=inns;
        iplBatting.notOut=notOut;
        iplBatting.runs=runs;
        iplBatting.highScore=highScore;
        iplBatting.avg=average;
        iplBatting.ballFaced=ballFaced;
        iplBatting.strikeRate=strikeRate;
        iplBatting.centuries=centuries;
        iplBatting.halfCenturies=fifties;
        iplBatting.fours=fours;
        iplBatting.sixes=sixs;
    }

    public CricketLeagueDao(IPLBowling iplBowling) {
      iplBowling.pos=pos;
      iplBowling.player=player;
      iplBowling.matches=matches;
      iplBowling.innings=inns;
      iplBowling.over=over;
      iplBowling.runs=runs;
      iplBowling.wickets=wickets;
      iplBowling.bestBowlingIndex=bestBowlingIndex;
      iplBowling.average=average;
      iplBowling.economy=economy;
      iplBowling.strikeRate=strikeRate;
      iplBowling.fourWickets=fourWickets;
      iplBowling.fiveWickets=fiveWickets;
    }
}
