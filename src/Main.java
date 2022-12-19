import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        ShortestPathAlgorithm myAlgorithm = RWOperations.readInputs();

        Instant start = Instant.now();
        myAlgorithm.run();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time: " + duration.toSeconds() + "s " + duration.toMillis() % 1000 + "ms " + duration.toNanos() % 1000000 + "ns");

        RWOperations.writeOutputs(myAlgorithm);
    }
}
