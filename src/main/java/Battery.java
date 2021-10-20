public class Battery extends Component {
    double voltage;

    public Battery(int sourceNode, int destNode, double voltage, String ID) {
        super(sourceNode, destNode, ID);
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "sourceNode=" + sourceNode +
                ", destNode=" + destNode +
                ", voltage=" + voltage +
                ", ID='" + ID + '\'' +
                '}';
    }
}
