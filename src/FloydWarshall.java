import java.util.ArrayList;

public class FloydWarshall extends ShortestPathAlgorithm {
    public FloydWarshall(int[][] dist, int nodes, ArrayList<Edge> edges) {
        super(dist, nodes,edges);
    }

    @Override
    public void run() {
        for (int k = 1; k <= nodes; k++) {
            for (int i = 1; i <= nodes; i++) {
                for (int j = 1; j <= nodes; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}