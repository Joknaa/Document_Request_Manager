package GLProject.Experiments.MyStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private static final JFrame myFrame = new JFrame("Main Menu");
    private static final JPanel mainMenu = new JPanel(new GridBagLayout());
    private static final JPanel adminSpace = new JPanel(new GridBagLayout());
    private static final JButton adminButton = new JButton("Admin");
    private static final JButton adminButton2 = new JButton("Admin");
    private static final JButton studentButton = new JButton("Student");
    private static final GridBagConstraints GBConstraint = new GridBagConstraints();

    static public void Display(){
        GBConstraint.insets = new Insets(10,10,10, 10);

        adminButton.addActionListener(new OnClickAction(mainMenu, adminSpace));
        mainMenu.add(adminButton, GBConstraint);
        mainMenu.add(studentButton, GBConstraint);

        adminButton2.addActionListener(new OnClickAction(adminSpace, mainMenu));
        adminSpace.add(adminButton2, GBConstraint);
        adminSpace.setVisible(false);

        myFrame.add(mainMenu, BorderLayout.NORTH);
        myFrame.add(adminSpace);
        myFrame.setSize(400, 200);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    static class OnClickAction implements ActionListener {
        private final JPanel fromPanel;
        private final JPanel toPanel;
        OnClickAction(JPanel fromPanel, JPanel toPanel){
            this.fromPanel = fromPanel;
            this.toPanel = toPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                fromPanel.setVisible(false);
                toPanel.setVisible(true);
        }
    }
}
