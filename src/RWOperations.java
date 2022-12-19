import java.util.Arrays;
import java.util.Scanner;

public final class RWOperations {
    public static Scanner scanner = new Scanner(System.in);
    public static int INF = 99999;

    private RWOperations() { }

    public static ShortestPathAlgorithm readInputs() {
        int[][] dist;
        int nodes;

        nodes = scanner.nextInt();
        dist = new int[nodes + 1][nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            Arrays.fill(dist[i], INF);
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

        ShortestPathAlgorithm newAlgorithm = new FloydWarshall(dist, nodes);
        return newAlgorithm;
    }

    public static void writeOutputs(ShortestPathAlgorithm algorithm) {
        int[][] dist = algorithm.getDist();
        int nodes = algorithm.getNodes();

        StringBuilder line;

        for (int i = 1; i <= nodes; i++) {
            line = new StringBuilder();
            for (int j = 1; j <= nodes; j++) {
                line.append((dist[i][j] < 99999 ? dist[i][j] : "NaN") + " ");
            }
            System.out.println(line.toString());
        }
    }
}
