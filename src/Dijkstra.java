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
        for(int nrIter = 1; nrIter <= nodes; nrIter++) {
            Arrays.fill(minDist, INF);
            Arrays.fill(viz, false);

            minDist[nrIter] = 0;

            checkNode(minDist, viz, nrIter);
            viz[nrIter] = true;

            for (int i = 2; i <= nodes; i++) {
                nextNode = findNextNode(minDist, viz);
                if (nextNode == 0) {
                    break;
                }
                checkNode(minDist, viz, nextNode);
                viz[nextNode] = true;
            }

            for (int i = 1; i <= nodes; i++) {
                dist[nrIter][i] = minDist[i];
            }
        }
    }
}
