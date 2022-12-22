import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Test {
    /**
     * args[0] = 1 for Dijkstra
     *           2 for Bellman-Ford
     *           3 for Floyd-Warshall
     */
    public static void main(String[] args) throws IOException{
        RWOperations.createFileTest();

        ShortestPathAlgorithm myAlgorithm = RWOperations.readInputs(Integer.parseInt(args[0]));

        Instant start = Instant.now();
        myAlgorithm.run();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time test: " + duration.toSeconds() + "s " + duration.toMillis() % 1000 + "ms " + duration.toNanos() % 1000000 + "ns");

        RWOperations.writeOutputs(myAlgorithm);
    }
}
