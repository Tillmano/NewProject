import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JDialog implements ActionListener {
    private JList list;
    private JLabel label;
    private JButton rButton, vButton;
    private DefaultListModel components;

    public GUI() {
        setLayout(new BorderLayout());
        label = new JLabel("List of components:");
        label.setFont(label.getFont().deriveFont(30.0f));
        add(label, (BorderLayout.PAGE_START));
        components = new DefaultListModel();
        list = new JList(components);
        list.setVisibleRowCount(3);
        add(new JScrollPane(list));
        list.setFont(list.getFont().deriveFont(30.0f));
        add(list, BorderLayout.CENTER);
        rButton = new JButton("Add resistor");
        add(rButton, BorderLayout.LINE_START);
        rButton.addActionListener(this);
        vButton = new JButton("Add battery");
        add(vButton, BorderLayout.LINE_END);
        vButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == rButton) {
            InputResistor input = new InputResistor(this);
            input.pack();
            input.setVisible(true);
            input.setSize(200, 400);
            input.setTitle("Input");
        }
        /*if(event.getSource() == rButton) {
            InputBattery input = new InputBattery(this);
            input.pack();
            input.setVisible(true);
            input.setSize(200, 400);
            input.setTitle("Input");
        }*/
    }

    public void setID(String ID) {
        components.addElement(ID);
    }


    public static void main(String args[]) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gui.setSize(screenSize.width, screenSize.height);
        gui.setTitle("GUI");
    }
}
