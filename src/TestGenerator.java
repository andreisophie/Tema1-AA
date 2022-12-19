

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestGenerator {
    private enum type {
        DIRECTED,
        UNDIRECTED
    }

    private static final int INF = 99999;
    private static final Random RANDOM = new Random();
    private static FileWriter outWriter;

    private static void generateTest(int nodes, int vertices, type graphType) throws IOException {
        // initialize graph structures
        int[][] dist = new int[nodes + 1][nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        int step;
        if (graphType == type.DIRECTED) {
            step = 1;
        } else {
            step = 2;
        }

        int n1, n2, cost;
        final int maxCost = 5 * nodes;
        for (int i = 0; i < vertices; i += step) {
            do {
                n1 = RANDOM.nextInt(nodes) + 1;
                n2 = RANDOM.nextInt(nodes) + 1;
                cost = RANDOM.nextInt(maxCost) + 1;
            } while (n1 == n2 || dist[n1][n2] != INF);
            dist[n1][n2] = cost;
            if (graphType == type.UNDIRECTED) {
                dist[n2][n1] = cost;
            }
        }

        outWriter.write(nodes + " " + vertices + "\n");
        for (int i = 1; i <= nodes; i++) {
            for (int j= 1; j <= nodes; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    continue;
                }
                outWriter.write(i + " " + j + " " + dist[i][j] + "\n");
            }
        }
    }

    /**
     * args[0] = number of nodes (int)
     * args[1] = graph density (double)
     * args[2] = "directed" or "undirected" (string)
     * args[3] = path to output file ("../in/testX.in")
     */
    public static void main(String[] args) throws IOException {
        int nodes = Integer.parseInt(args[0]);
        double density = Double.parseDouble(args[1]);
        String graphTypeString = args[2];
        type graphType;
        switch(graphTypeString) {
            case "directed" -> {
                graphType = type.DIRECTED;
            }
            case "undirected" -> {
                graphType = type.UNDIRECTED;
            }
            default -> {
                System.out.println("Invalid graph type!");
                return;
            }
        }
        String outName = args[3];
        File outFile = new File(outName);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);

        generateTest(nodes, (int)(nodes * (nodes - 1) * density), graphType);

        outWriter.close();
    }
}
