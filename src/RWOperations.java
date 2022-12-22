import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public final class RWOperations {

    private static File inFile;
    private static File outFile;
    private static Scanner scanner;
    private static FileWriter outWriter;

    private RWOperations() { }

    public static void createFiles(int testNumber) throws IOException {
        String inPath = new String("in/test" + testNumber + ".in");
        inFile = new File(inPath);
        scanner = new Scanner(inFile);

        File directory = new File("out");
        if (!directory.exists()) {
            directory.mkdir();
        }

        String outPath = new String("out/test" + testNumber + ".out");
        outFile = new File(outPath);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);
    }

    public static void createFileTest() throws IOException {
        String inPath = new String("test.in");
        inFile = new File(inPath);
        scanner = new Scanner(inFile);

        String outPath = new String("test.out");
        outFile = new File(outPath);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);
    }

    public static ShortestPathAlgorithm readInputs(int algorithmType) {
        int[][] dist;
        int nodes;
        ArrayList<Edge> edges = new ArrayList<>();

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
            edges.add(new Edge(n1, n2, cost));
        }

        return switch (algorithmType) {
            case 1 -> new Dijkstra(dist, nodes, edges);
            case 2 -> new BellmanFord(dist, nodes, edges);
            case 3 -> new FloydWarshall(dist, nodes, edges);
            default -> {
                System.out.println("Invalid algorithm");
                System.exit(-1);
                yield null;
            }
        };
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
