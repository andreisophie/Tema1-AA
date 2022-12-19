import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public final class RWOperations {

    private static File inFile;
    private static File outFile;
    private static Scanner scanner;
    private static FileWriter outWriter;

    private RWOperations() { }

    public static void createFiles(int testNumber) throws IOException {
        String inName = new String("in/test" + testNumber + ".in");
        inFile = new File(inName);
        scanner = new Scanner(inFile);

        File directory = new File("out");
        if (!directory.exists()) {
            directory.mkdir();
        }

        String outName = new String("out/test" + testNumber + ".out");
        outFile = new File(outName);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);
    }

    public static ShortestPathAlgorithm readInputs(int algorithmType) {
        int[][] dist;
        int nodes;

        nodes = scanner.nextInt();
        dist = new int[nodes + 1][nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            Arrays.fill(dist[i], ShortestPathAlgorithm.INF);
            dist[i][i] = 0;
        }

        int vertices = scanner.nextInt();
        int n1, n2, cost;
        for (int i = 0; i < vertices; i++) {
            n1 = scanner.nextInt();
            n2 = scanner.nextInt();
            cost = scanner.nextInt();

            dist[n1][n2] = cost;
        }

        switch (algorithmType) {
            case 1 -> {
                return new Dijkstra(dist, nodes);
            }
            case 2 -> {
                return new BellmanFord(dist, nodes);
            }
            case 3 -> {
                return new FloydWarshall(dist, nodes);
            }
            default -> {
                System.out.println("Invalid algorithm");
                System.exit(-1);
                return null;
            }
        }
    }

    public static void writeOutputs(ShortestPathAlgorithm algorithm) throws IOException {
        int[][] dist = algorithm.getDist();
        int nodes = algorithm.getNodes();

        StringBuilder line;

        for (int i = 1; i <= nodes; i++) {
            line = new StringBuilder();
            for (int j = 1; j <= nodes; j++) {
                line.append((dist[i][j] < ShortestPathAlgorithm.INF ? dist[i][j] : "NaN") + " ");
            }
            line.append("\n");
            outWriter.write(line.toString());
        }

        outWriter.close();
    }
}
