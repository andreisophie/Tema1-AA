import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main {
    private static final int NR_TESTS = 30;

    public static void main(String[] args) throws IOException{
        for (int i = 1; i <= NR_TESTS; i++) {
            RWOperations.createFiles(i);

            ShortestPathAlgorithm myAlgorithm = RWOperations.readInputs();

            Instant start = Instant.now();
            myAlgorithm.run();
            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);
            System.out.println("Execution time test " + i + ": " + duration.toSeconds() + "s " + duration.toMillis() % 1000 + "ms " + duration.toNanos() % 1000000 + "ns");

            RWOperations.writeOutputs(myAlgorithm);
        }
    }
}
