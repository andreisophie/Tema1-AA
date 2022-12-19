import java.util.Arrays;

public class Dijkstra extends ShortestPathAlgorithm {
    public Dijkstra(int[][] dist, int nodes) {
        super(dist, nodes);
    }

    private int findNextNode(int[] minDist, boolean[] viz) {
        int nextNode = 0;
        int min = INF;

        for (int i = 1; i <= nodes; i++) {
            if (viz[i]) {
                continue;
            }
            if (min > minDist[i]) {
                nextNode = i;
                min = minDist[i];
            }
        }

        return nextNode;
    }

    private void checkNode(int[] minDist, boolean[] viz, int currentNode) {
        for (int i = 1; i <= nodes; i++) {
            if (viz[i] || dist[currentNode][i] == INF) {
                continue;
            }
            if (minDist[currentNode] + dist[currentNode][i] < minDist[i]) {
                minDist[i] = minDist[currentNode] + dist[currentNode][i];
            }
        }
    }

    @Override
    public void run() {
        int[] minDist = new int[nodes + 1];
        boolean[] viz = new boolean[nodes + 1];
        int nextNode;
        for(int k = 1; k <= nodes; k++) {
            Arrays.fill(minDist, INF);
            Arrays.fill(viz, false);

            minDist[k] = 0;

            checkNode(minDist, viz, k);
            viz[k] = true;

            for (int i = 2; i <= nodes; i++) {
                nextNode = findNextNode(minDist, viz);
                if (nextNode == 0) {
                    break;
                }
                checkNode(minDist, viz, nextNode);
                viz[nextNode] = true;
            }

            for (int i = 1; i <= nodes; i++) {
                dist[k][i] = minDist[i];
            }
        }
    }
}
