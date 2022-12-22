public class Edge {
    private int n1, n2, cost;

    public Edge(int n1, int n2, int cost) {
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int src) {
        this.n1 = src;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int dest) {
        this.n2 = dest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}