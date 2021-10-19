public class Resistor {
    int sourceNode, destNode;
    double resistance;
    String ID;

    public Resistor(int sourceNode, int destNode, double resistance, String ID) {
        this.destNode = destNode;
        this.sourceNode = sourceNode;
        this.resistance = resistance;
        this.ID = ID;
    }
}
