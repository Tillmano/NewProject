public class Resistor extends Component {
    double resistance;

    public Resistor(int sourceNode, int destNode, double resistance, String ID) {
        super(sourceNode, destNode, ID);
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "Resistor{" +
                "sourceNode=" + sourceNode +
                ", destNode=" + destNode +
                ", resistance=" + resistance +
                ", ID='" + ID + '\'' +
                '}';
    }
}
