public class Main {
    public static void main(String[] args) {
        ShortestPathAlgorithm myAlgorithm = RWOperations.readInputs();

        myAlgorithm.run();

        RWOperations.writeOutputs(myAlgorithm);
    }
}
