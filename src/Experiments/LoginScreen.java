package Experiments;

import static Experiments.OutputView.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class LoginScreen implements IMenu{
    private static final JPanel loginPanel = new JPanel();
    private static final JLabel userLabel = new JLabel("Username");
    private static final JTextField userText = new JTextField(30);
    private static final JLabel passwdLabel = new JLabel("Password");
    private static final JPasswordField passwdField = new JPasswordField();
    private static final JButton buttonCheck = new JButton("Login");
    private static final JButton button = new JButton("direct");
    private static final JLabel success = new JLabel();

    public JPanel GetPanel(){ return loginPanel; }
    public void Display(JFrame appFrame){
        SetupPanel();
        appFrame.add(loginPanel);
        appFrame.setTitle("Login Admin");
    }
    private static void SetupPanel() {
        loginPanel.removeAll();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(null);

        SetupComponent(userLabel,10, 20, 80, 25);
        SetupComponent(userText,100, 20, 165, 26);
        SetupComponent(passwdLabel,10, 80, 80, 25);
        SetupComponent(passwdField,100, 80, 165,26);
        SetupComponent(buttonCheck,130, 140, 100, 30);
        SetupComponent(button,230, 140, 100, 30);
        SetupComponent(success,10, 170, 100, 30);

        buttonCheck.addActionListener(new OnClickAction(loginMenu, adminMenu));
        button.addActionListener(new OnClick_SwapFrames(loginMenu, adminMenu));
    }
    private static void SetupComponent(JComponent Component,int x, int y, int w, int h) {
        Component.setBounds(x, y, w, h);
        loginPanel.add(Component);
    }

    static class OnClickAction extends OnClick_SwapFrames {
        OnClickAction(IMenu fromManu, IMenu toMenu) { super(fromManu, toMenu); }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (LoginCorrect() && PasswordCorrect()) super.actionPerformed(null);
            else success.setText("Login Failed!");
        }
        private boolean PasswordCorrect() {
            return Arrays.equals(passwdField.getPassword(), "admina".toCharArray());
        }
        private boolean LoginCorrect() {
            return userText.getText().equals("admin");
        }
    }
}
