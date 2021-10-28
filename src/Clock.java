import java.time.Duration;
import java.time.Instant;

public class Clock {

    public Instant timeStart() {
        Instant start = Instant.now();
        return start;
    }

    public Instant timeEnd(){
        Instant end = Instant.now();
        return end;
    }

    public String elapsedTime(Instant start, Instant end){
        String elapsed = Duration.between(start, end).toString();
        return elapsed;
    }
}
