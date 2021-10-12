import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    private String[] components = {"1", "2", "3", "4", "5"};
    private JList list;
    private JLabel label;
    private JButton button;

    public GUI() {
        setLayout(new FlowLayout());
        label = new JLabel("List of components:");
        add(label);
        list = new JList(components);
        add(list);
        button = new JButton("Add component");
        add(button);

        event e = new event();

        button.addActionListener(e);
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InputWindow input = new InputWindow();
            input.setVisible(true);
            input.setSize(300, 150);
        }
    }

    public static void main(String args[]) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(300, 150);
        gui.setTitle("GUI");
    }
}
