package GLProject.Experiments;

import static GLProject.Experiments.OutputView.*;
import javax.swing.*;
import java.awt.*;

public class MainMenu implements IMenu{
    private static final JPanel mainPanel = new JPanel();
    private static final JButton adminButton   = new JButton("Espace Administration");
    private static final JButton studentButton = new JButton("Espace Etudiant");

    public JPanel GetPanel(){ return SetupPanel(); }
    public void Display(JFrame appFrame) {
        SetupPanel();
        appFrame.add(mainPanel);
        appFrame.setTitle("Service Etudiant");
        appFrame.setSize(600, 350);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
    private static JPanel SetupPanel() {
        SetupButton(adminButton, 50);
        SetupButton(studentButton, 300);

        adminButton.addActionListener(new OnClick_SwapFrames(mainMenu, loginMenu));
        studentButton.addActionListener(new OnClick_SwapFrames(mainMenu, studentMenu));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        mainPanel.setLayout(null);
        mainPanel.add(adminButton);
        mainPanel.add(studentButton);
        mainPanel.setBackground(Color.lightGray);
        return mainPanel;
    }
    private static void SetupButton(JButton button, int xPosition) {
        button.setBounds(xPosition, 80, 200, 100);
        button.setBackground(Color.cyan);
    }
}