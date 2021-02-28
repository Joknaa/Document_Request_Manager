package New.MVPViews.UI;

import static New.MVPViews.OutputView.*;
import javax.swing.*;
import static New.MVPViews.OutputView.SetupMainPanelLayout;
import static javax.swing.GroupLayout.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel implements IPanel, ActionListener {
    //<editor-fold desc="Variables Declarations">">
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JSeparator loginSeparator = new JSeparator();
    private final JSeparator passwordSeparator = new JSeparator();
    private final JLabel LogoIconLabel = new JLabel(new ImageIcon("Resources/library_120px.png"));
    private final JLabel passwordLabel = new JLabel(new ImageIcon("Resources/lock_30px.png"));
    private final JLabel loginLabel = new JLabel(new ImageIcon("Resources/user_30px.png"));
    private final JLabel LogoTextLabel = new JLabel("Request Manager");
    private final JButton signInButton = new JButton("Sign In");
    private final JButton signUpButton = new JButton("Sign Up");
    private final JButton closeButton = new JButton("X");
    private final JButton backButton = new JButton("Back");
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField loginField = new JTextField();
    //</editor-fold>

    public LoginPanel() {
        SetupLogoPanel();
        SetupInputPanel();
        SetupMainPanelLayout(logoPanel, inputPanel, this);
    }

    private void SetupLogoPanel() {
        logoPanel.setBackground(PICKLED_BLUEWOOD);
        SetupLogoTextPanel();
        SetupLogoPanelLayout(logoPanel, LogoIconLabel, LogoTextLabel);
    }
    private void SetupLogoTextPanel() {
        LogoTextLabel.setForeground(BLUE_BAYOUX);
        LogoTextLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
    }

    private void SetupInputPanel() {
        inputPanel.setBackground(BLUE_BAYOUX);
        SetupCloseButton(closeButton);
        SetupInputFields(loginField, passwordField);
        SetupSeparators(loginSeparator,passwordSeparator);
        SetupSubmitButton(signInButton, this, true, "Click to login");
        SetupSubmitButton(signUpButton, this, true, "Click to creat an account");
        SetupSubmitButton(backButton, this, true, "Back to starting page");

        SetupInputPanelLayout();
    }
    private void SetupInputPanelLayout() {
        var inputPanelLayout = new GroupLayout(inputPanel);

        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(passwordLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginLabel))
                                                .addGap(26, 26, 26)
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(loginSeparator)
                                                        .addComponent(loginField)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE)))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addComponent(signInButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(signUpButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(15, 15, 15)))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(backButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(173, 173, 173))))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(loginLabel)
                                        .addComponent(loginField, PREFERRED_SIZE, 40, PREFERRED_SIZE))
                                .addComponent(loginSeparator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(passwordField, PREFERRED_SIZE, 39, PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(0, 0, 0)
                                .addComponent(passwordSeparator, PREFERRED_SIZE, 13, PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(signInButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(signUpButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );
    }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ setVisible(true);}
    @Override
    public void Deactivate(){ setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent event) {
        if      (event.getSource().equals(signInButton)) OnClick_SignIn(loginField, passwordField);
        else if (event.getSource().equals(signUpButton)) OnClick_SwapPanels(loginPanel, signUpPanel);
        else if (event.getSource().equals(backButton))   OnClick_SwapPanels(loginPanel, startingPanel);
    }
}