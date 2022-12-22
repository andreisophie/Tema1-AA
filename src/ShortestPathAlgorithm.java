import java.util.ArrayList;

public abstract class ShortestPathAlgorithm {
    protected int[][] dist;
    protected int nodes;
    ArrayList<Edge> edges;

    public static final int INF = 99999;

    public abstract void run();

    public ShortestPathAlgorithm(int[][] dist, int nodes, ArrayList<Edge> edges) {
        this.dist = dist;
        this.nodes = nodes;
        this.edges = edges;
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
