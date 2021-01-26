package GLProject.Experiments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    private static final JFrame mainFrame = new JFrame();
    private static final JPanel mainPanel = new JPanel();
    private static final JButton adminButton   = new JButton("Espace Administration");
    private static final JButton studentButton = new JButton("Espace Etudiant");

    public static void Display() {
        SetupButton(adminButton, 50);
        SetupButton(studentButton, 300);

        // the panel with the button
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        mainPanel.setLayout(null);
        mainPanel.add(adminButton);
        mainPanel.add(studentButton);
        mainPanel.setBackground(Color.lightGray);

        // set up the frame and display it
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Service Etudiant");
        mainFrame.setSize(600, 350);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private static void SetupButton(JButton button, int xPosition) {
        button.setBounds(xPosition, 80, 200, 100);
        button.addActionListener(new OnClickAction());
        button.setBackground(Color.cyan);
    }

    static class OnClickAction implements ActionListener {

        OnClickAction(){ }

        @Override
        public void actionPerformed(ActionEvent event) {
            mainFrame.setVisible(false);
            if(event.getSource() == adminButton)
                LoginScreen.Display();
            else if(event.getSource() == studentButton)
                StudentScreen.Display();
        }
    }
}