import java.util.Arrays;

public class BellmanFord extends ShortestPathAlgorithm {
    public BellmanFord(int[][] dist, int nodes) {
        super(dist, nodes);
    }

    @Override
    public void run() {
        int[] minDist = new int[nodes + 1];
        boolean[] viz = new boolean[nodes + 1];

        for(int nrIter = 1; nrIter <= nodes; nrIter++) {
            Arrays.fill(minDist, INF);
            Arrays.fill(viz, false);

            minDist[nrIter] = 0;

            for (int k = 1; k < nodes; k++) {
                for (int i = 1; i <= nodes; i++) {
                    for (int j = 1; j <= nodes; j++) {
                        if (i == j || dist[i][j] == INF) {
                            continue;
                        }
                        if (minDist[i] + dist[i][j] < minDist[j]) {
                            minDist[j] = minDist[i] + dist[i][j];
                        }
                    }
                }
            }

            for (int i = 1; i <= nodes; i++) {
                dist[nrIter][i] = minDist[i];
            }
        }
    }
}
