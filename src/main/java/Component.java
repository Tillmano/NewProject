abstract public class Component {
    int sourceNode, destNode, ID;
    double current;
    //Constructs a component, it can not be instantiated because it is abstract.
    public Component(int sourceNode, int destNode, int ID, double current) {
        this.sourceNode = sourceNode;
        this.destNode = destNode;
        this.ID = ID;
        this.current = current;
    }
}
