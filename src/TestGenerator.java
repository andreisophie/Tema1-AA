import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestGenerator {
    private static final int INF = 99999;
    private static final Random RANDOM = new Random();

    

    private static void generateTest(TestParams params) throws IOException {
        // initialize graph structures
        int[][] dist = new int[params.nodes + 1][params.nodes + 1];

        for (int i = 1; i <= params.nodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        int step;
        if (params.graphType == type.DIRECTED) {
            step = 1;
        } else {
            step = 2;
        }

        int n1, n2, cost;
        final int maxCost = 5 * params.nodes;
        for (int i = 0; i < params.vertices; i += step) {
            do {
                n1 = RANDOM.nextInt(params.nodes) + 1;
                n2 = RANDOM.nextInt(params.nodes) + 1;
                cost = RANDOM.nextInt(maxCost) + 1;
            } while (n1 == n2 || dist[n1][n2] != INF);
            dist[n1][n2] = cost;
            if (params.graphType == type.UNDIRECTED) {
                dist[n2][n1] = cost;
            }
        }

        params.outWriter.write(params.nodes + " " + params.vertices + "\n");
        for (int i = 1; i <= params.nodes; i++) {
            for (int j= 1; j <= params.nodes; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    continue;
                }
                params.outWriter.write(i + " " + j + " " + dist[i][j] + "\n");
            }
        }

        params.outWriter.close();
    }

    /**
     * args[0] = number of nodes (int)
     * args[1] = graph density (double)
     * args[2] = "directed" or "undirected" (string)
     * args[3] = path to output file ("../in/testX.in")
     */
    public static void main(String[] args) throws IOException {
        final TestParams[] testsParams = {
            // directed, sparse
            new TestParams(10, 0.2, type.DIRECTED, "in"),
            new TestParams(35, 0.2, type.DIRECTED, "in"),
            new TestParams(100, 0.2, type.DIRECTED, "in"),
            new TestParams(350, 0.2, type.DIRECTED, "in"),
            new TestParams(1000, 0.2, type.DIRECTED, "in"),
            // directed, normal density
            new TestParams(10, 0.5, type.DIRECTED, "in"),
            new TestParams(35, 0.5, type.DIRECTED, "in"),
            new TestParams(100, 0.5, type.DIRECTED, "in"),
            new TestParams(350, 0.5, type.DIRECTED, "in"),
            new TestParams(1000, 0.5, type.DIRECTED, "in"),
            // directed, dense
            new TestParams(10, 0.8, type.UNDIRECTED, "in"),
            new TestParams(35, 0.8, type.UNDIRECTED, "in"),
            new TestParams(100, 0.8, type.UNDIRECTED, "in"),
            new TestParams(350, 0.8, type.UNDIRECTED, "in"),
            new TestParams(1000, 0.8, type.UNDIRECTED, "in"),
            // undirected, sparse
            new TestParams(10, 0.2, type.UNDIRECTED, "in"),
            new TestParams(35, 0.2, type.UNDIRECTED, "in"),
            new TestParams(100, 0.2, type.UNDIRECTED, "in"),
            new TestParams(350, 0.2, type.UNDIRECTED, "in"),
            new TestParams(1000, 0.2, type.UNDIRECTED, "in"),
            // undirected, normal density
            new TestParams(10, 0.5, type.UNDIRECTED, "in"),
            new TestParams(35, 0.5, type.UNDIRECTED, "in"),
            new TestParams(100, 0.5, type.UNDIRECTED, "in"),
            new TestParams(350, 0.5, type.UNDIRECTED, "in"),
            new TestParams(1000, 0.5, type.UNDIRECTED, "in"),
            // undirected, dense
            new TestParams(10, 0.8, type.UNDIRECTED, "in"),
            new TestParams(35, 0.8, type.UNDIRECTED, "in"),
            new TestParams(100, 0.8, type.UNDIRECTED, "in"),
            new TestParams(350, 0.8, type.UNDIRECTED, "in"),
            new TestParams(1000, 0.8, type.UNDIRECTED, "in"),
        };

        for (int i = 0; i < TestParams.testNumber; i++) {
            generateTest(testsParams[i]);
        }
    }
}
