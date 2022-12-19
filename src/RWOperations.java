import java.util.Scanner;

import javax.xml.crypto.AlgorithmMethod;

public final class RWOperations {
    public static Scanner scanner = new Scanner(System.in);

    private RWOperations() { }

    public static ShortestPathAlgorithm readInputs() {
        int[][] distances;
        int nodes;

        nodes = scanner.nextInt();
        distances = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distances[i][j] = scanner.nextInt();
            }
        }

        ShortestPathAlgorithm newAlgorithm = new FloydWarshall(distances, nodes, cols);
        return newAlgorithm;
    }

    public static void writeOutputs(ShortestPathAlgorithm algorithm) {
        int[][] distances = algorithm.getDistances();
        int nodes = algorithm.getNodes();

        for (int i = 0; i < nodes; i++) {
            System.out.println(distances[i]);
        }
    }
}
