import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JDialog implements ActionListener {
    private JList list;
    private JLabel label;
    private JButton rButton, vButton;
    private DefaultListModel components;

    public GUI() {

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


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(rButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(vButton);
        Container contentPane = getContentPane();
        contentPane.add(listPane, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == rButton) {
            InputResistor input = new InputResistor(this);
            input.pack();
            input.setVisible(true);
            input.setSize(200, 400);
            input.setTitle("Input");

        }else if(event.getSource() == vButton) {
            InputBattery input = new InputBattery(this);
            input.pack();
            input.setVisible(true);
            input.setSize(200, 400);
            input.setTitle("Input");
        }
    }

    public void setResistor(String ID, int sourceNode, int destNode, double resistance) {
        Resistor resistor = new Resistor(sourceNode, destNode, resistance, ID);
        components.addElement(resistor);
    }
    public void setBattery(String ID, int sourceNode, int destNode, double voltage) {
        Battery battery = new Battery(sourceNode, destNode, voltage, ID);
        components.addElement(battery);
    }


    public static void main(String args[]) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(500, 500);
        gui.setTitle("GUI");
    }
}