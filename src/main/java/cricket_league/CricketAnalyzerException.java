package cricket_league;

public class CricketAnalyzerException extends  Exception{

    public enum ExceptionType {

        FILE_PROBLEM,INCORRECT_FILE_DATA,NULL_POINTER_EXCEPTION,NO_SUCH_FILE;
    }

    public ExceptionType type;

    public CricketAnalyzerException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
