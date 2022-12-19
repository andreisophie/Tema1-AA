public abstract class ShortestPathAlgorithm {
    private int[][] distances;
    private int nodes;

    public abstract void run();

    public ShortestPathAlgorithm(int[][] distances, int lines, int cols) {
        this.distances = distances;
        this.nodes = lines;
    }

    public int[][] getDistances() {
        return distances;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int lines) {
        this.nodes = lines;
    }
}
