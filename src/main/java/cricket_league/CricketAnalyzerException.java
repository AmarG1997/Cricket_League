package cricket_league;

public class CricketAnalyzerException extends  Exception{

    public enum ExceptionType {

        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE,INCORRECT_FILE_DATA,NULL_POINTER_EXCEPTION,NO_SUCH_COUNTRY;
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
