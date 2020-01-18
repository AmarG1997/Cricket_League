package cricket_league;

public class IPLBattingDAO {

    public int pos;
    public String player;
    public int matches;
    public int inns;
    public int notOut;
    public int runs;
    public int highScore;
    public double avg;
    public int ballFaced;
    public double strikeRate;
    public int centuries;
    public int halfCenturies;
    public int fours;
    public int sixes;

    public IPLBattingDAO(IPLBattingCsv iplBattingCsv) {
        pos=iplBattingCsv.pos;
        player=iplBattingCsv.player;
        matches=iplBattingCsv.matches;
        inns=iplBattingCsv.inns;
        notOut=iplBattingCsv.notOut;
        runs=iplBattingCsv.runs;
        highScore=iplBattingCsv.highScore;
        avg=iplBattingCsv.avg;
        ballFaced=iplBattingCsv.ballFaced;
        strikeRate=iplBattingCsv.strikeRate;
        iplBattingCsv.centuries=centuries;
        iplBattingCsv.halfCenturies=halfCenturies;
        iplBattingCsv.fours=fours;
        iplBattingCsv.sixes=sixes;
    }

    public IPLBattingDAO(int pos, String player, int matches, int inns, int notOut, int runs,
                         int highScore, double avg, int ballFaced, double strikeRate, int centuries,
                         int halfCenturies, int fours, int sixes) {
        this.pos = pos;
        this.player = player;
        this.matches = matches;
        this.inns = inns;
        this.notOut = notOut;
        this.runs = runs;
        this.highScore = highScore;
        this.avg = avg;
        this.ballFaced = ballFaced;
        this.strikeRate = strikeRate;
        this.centuries = centuries;
        this.halfCenturies = halfCenturies;
        this.fours = fours;
        this.sixes = sixes;
    }


    public IPLBattingDAO() {
    }
}
