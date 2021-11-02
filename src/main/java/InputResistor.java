import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputResistor extends JDialog implements ActionListener {
    private JButton button;
    private JTextField sourceTextfield, destTextfield, IdTextfield, rTextfield;
    private JLabel sourcePromptlabel, destPromptlabel, IdPromptLabel, rPromptLabel;
    private GUI owner;

    public InputResistor(GUI owner) {
        super(owner, true);

        this.owner = owner;
        setLayout(new FlowLayout());
        IdPromptLabel = new JLabel("Enter the component's ID");
        add(IdPromptLabel);
        IdTextfield = new JTextField(5);
        add(IdTextfield);
        sourcePromptlabel = new JLabel("Enter the source node");
        add(sourcePromptlabel);
        sourceTextfield = new JTextField(5);
        add(sourceTextfield);
        destPromptlabel = new JLabel("Enter the destination node");
        add(destPromptlabel);
        destTextfield = new JTextField(5);
        add(destTextfield);
        rPromptLabel = new JLabel("Enter the resistance");
        add(rPromptLabel);
        rTextfield = new JTextField(5);
        add(rTextfield);
        button = new JButton("Enter");
        add(button);
        button.addActionListener(this);
    }




    public void actionPerformed(ActionEvent e) {
        try {
            int sourceNode = (int) (Double.parseDouble(sourceTextfield.getText()));
            int destNode = (int) (Double.parseDouble(destTextfield.getText()));
            int ID = (int) (Double.parseDouble(IdTextfield.getText()));
            Double resistance = (Double.parseDouble(rTextfield.getText()));
            Resistor resistor = new Resistor(sourceNode, destNode, resistance, ID);
            owner.addComponent(resistor);
        } catch (NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(null,
                    "Error: You must enter an integer for the Nodes and ID and a Double for the resistance");
        }

        dispose();
    }
}