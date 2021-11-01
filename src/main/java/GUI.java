import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.*;

public class GUI extends JDialog implements ActionListener {
    private JList list;
    private JLabel label;
    private JButton rButton, vButton, sButton;
    private DefaultListModel components;


    public GUI() {
        Solver solver = new Solver();

        label = new JLabel("List of components:");
        label.setFont(label.getFont().deriveFont(30.0f));
        add(label, (BorderLayout.PAGE_START));
        components = new DefaultListModel<Component>();
        list = new JList(components);
        list.setVisibleRowCount(3);
        add(new JScrollPane(list));
        list.setFont(list.getFont().deriveFont(30.0f));
        add(list);
        rButton = new JButton("Add resistor");
        add(rButton);
        rButton.addActionListener(this);
        vButton = new JButton("Add battery");
        add(vButton);
        vButton.addActionListener(this);
        sButton = new JButton("Solve");
        add(sButton);
        sButton.addActionListener(this);


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
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(sButton);
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
        }else if(event.getSource() == sButton){
            ArrayList<Component> c = new ArrayList<>();
            for (Enumeration<Component> e = components.elements(); e.hasMoreElements();) {
                c.add(e.nextElement());
            }
            Solver.solve(c);
        }
    }

    public void addComponent(Component component){
        components.addElement(component);
    }


    public static void main(String args[]) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(500, 500);
        gui.setTitle("GUI");
    }
}