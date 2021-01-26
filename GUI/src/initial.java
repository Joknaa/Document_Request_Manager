import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class initial implements ActionListener{
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JButton admin = new JButton("Espace Administration");
    private static JButton etu = new JButton("Espace Etudiant");

    public static void GUI () {

        // the clickable button
        admin.setBounds(50, 80, 200, 100);
        //admin.setBackground(Color.cyan);

        // process the button clicks
        admin.addActionListener(new initial());

        etu.setBounds(300, 80, 200, 100);

        // process the second button clicks
        etu.addActionListener(new initial());

        // the panel with the button
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(admin);
        panel.add(etu);
        panel.setBackground(Color.lightGray);
        admin.setBackground(Color.cyan);
        etu.setBackground(Color.cyan);

        // set up the frame and display it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Service Etudiant");
        frame.setSize(600, 350);
        frame.add(panel);
        frame.setVisible(true);

    }

    // create one Frame
    public static void main(String[] args) {
        GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == admin) {
            frame.setVisible(false);
            login a = new login();
            a.showFrame();
        }
        else if(e.getSource() == etu) {
            frame.setVisible(false);
            etu b = new etu();
            b.showPage();
        }
    }

}