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
}
