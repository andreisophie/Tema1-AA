public abstract class ShortestPathAlgorithm {
    protected int[][] dist;
    protected int nodes;

    public static final int INF = 99999;

    public abstract void run();

    public ShortestPathAlgorithm(int[][] dist, int nodes) {
        this.dist = dist;
        this.nodes = nodes;
    }

    public int[][] getDist() {
        return dist;
    }

    public void setDist(int[][] dist) {
        this.dist = dist;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int lines) {
        this.nodes = lines;
    }
}
