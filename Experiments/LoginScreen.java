package GLProject.Experiments;

import static GLProject.Experiments.OutputView.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginScreen implements IMenu{
    private static final JPanel panel = new JPanel();
    private static final JLabel userLabel = new JLabel("Username");
    private static final JTextField userText = new JTextField(30);
    private static final JLabel passwdLabel = new JLabel("Password");
    private static final JPasswordField passwdField = new JPasswordField();
    private static final JButton button = new JButton("Login");
    private static final JLabel success = new JLabel();

    public JPanel GetPanel(){ return SetupPanel(); }
    public void Display(JFrame appFrame){
        SetupPanel();
        appFrame.add(panel);
        appFrame.setTitle("Login Admin");
        appFrame.setSize(500, 300);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
    private static JPanel SetupPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        SetupComponent(userLabel,10, 20, 80, 25);
        SetupComponent(userText,100, 20, 165, 26);
        SetupComponent(passwdLabel,10, 80, 80, 25);
        SetupComponent(passwdField,100, 80, 165,26);
        SetupComponent(button,130, 140, 100, 30);
        SetupComponent(success,10, 170, 100, 30);

        button.addActionListener(new OnClickAction(loginMenu, adminMenu));
        return panel;
    }
    private static void SetupComponent(JComponent Component,int x, int y, int w, int h) {
        Component.setBounds(x, y, w, h);
        panel.add(Component);
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
