import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord extends ShortestPathAlgorithm {
    public BellmanFord(int[][] dist, int nodes, ArrayList<Edge> edges) {
        super(dist, nodes,edges);
    }

    @Override
    public void run() {
        for (int i = 1; i <= nodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int k = 1; k < nodes; k++) {
            for (Edge edge : edges) {
                int n1 = edge.getN1();
                int n2 = edge.getN2();
                int cost = edge.getCost();
                for (int i = 1; i <= nodes; i++) {
                    if (dist[i][n1] + cost < dist[i][n2]) {
                        dist[i][n2] = dist[i][n1] + cost;
                    }
                }
            }
        }
    }
}
