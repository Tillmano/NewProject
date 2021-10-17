import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JDialog implements ActionListener {
    private String[] components = {"1 Resistor 9 ohms 1 amp", "2", "3", "4", "5"};
    private JList list;
    private JLabel label;
    private JButton button;

    public GUI() {
        setLayout(new FlowLayout());
        label = new JLabel("List of components:");
        label.setFont(label.getFont().deriveFont(30.0f));
        add(label);
        list = new JList(components);
        list.setFont(list.getFont().deriveFont(30.0f));
        add(list);
        button = new JButton("Add component");
        add(button);

        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        InputWindow input = new InputWindow(this);
        input.pack();
        input.setVisible(true);
        input.setSize(200, 400);
        input.setTitle("Input");
    }

    public void setID(String ID) {
        System.out.println(ID);
    }


    public static void main(String args[]) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(800, 300);
        gui.setTitle("GUI");
    }
}
