package New.MVPViews.UI;

import static javax.swing.GroupLayout.*;
import static New.MVPViews.OutputView.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPanel extends JPanel implements IPanel, ActionListener {
    //<editor-fold desc="Variables Declarations">">
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JSeparator loginSeparator = new JSeparator();
    private final JSeparator passwordSeparator = new JSeparator();
    private final JSeparator passwordRepeatSeparator = new JSeparator();
    private final JLabel logoIconLabel = new JLabel(new ImageIcon("Resources/library_120px.png"));
    private final JLabel passwordLabel = new JLabel(new ImageIcon("Resources/lock_30px.png"));
    private final JLabel passwordRepeatLabel = new JLabel(new ImageIcon("Resources/lock_30px.png"));
    private final JLabel loginLabel = new JLabel(new ImageIcon("Resources/user_30px.png"));
    private final JLabel logoTextLabel = new JLabel("Multimedia Library");
    private final JButton signUpButton = new JButton("Sign Up");
    private final JButton closeButton = new JButton("X");
    private final JPasswordField passwordField = new JPasswordField();
    private final JPasswordField passwordRepeatField = new JPasswordField();
    private final JTextField loginField = new JTextField();
    //</editor-fold>

    public SignupPanel() {
        SetupLogoPanel();
        SetupInputPanel();
        SetupMainPanel();
    }

    private void SetupLogoPanel() {
        logoPanel.setBackground(PICKLED_BLUEWOOD);
        SetupLogoPanelLayout(logoPanel, logoIconLabel, logoTextLabel);
        SetupLogoTextPanel();
    }
    private void SetupLogoTextPanel() {
        logoTextLabel.setForeground(BLUE_BAYOUX);
        logoTextLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
    }

    private void SetupInputPanel() {
        inputPanel.setBackground(BLUE_BAYOUX);
        SetupInputFields(loginField, passwordField, passwordRepeatField);
        SetupSeparators(loginSeparator, passwordSeparator, passwordRepeatSeparator);
        SetupSubmitButton(signUpButton, this, true,"Click to creat an account");
        SetupCloseButton(closeButton);
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
                                        .addComponent(passwordRepeatLabel)
                                        .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(passwordLabel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginLabel)))
                                .addGap(26, 26, 26)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(loginSeparator)
                                                .addComponent(loginField)
                                                .addComponent(passwordField)
                                                .addComponent(passwordSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(passwordRepeatField)
                                                .addComponent(passwordRepeatSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE)))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(signUpButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(173, 173, 173))
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(8, 8, 8))))
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
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(passwordRepeatField, PREFERRED_SIZE, 39, PREFERRED_SIZE)
                                        .addComponent(passwordRepeatLabel))
                                .addGap(0, 0, 0)
                                .addComponent(passwordRepeatSeparator, PREFERRED_SIZE, 13, PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(signUpButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121)
                        )
        );
    }

    private void SetupMainPanel() {
        SetupMainPanelLayout();
    }
    private void SetupMainPanelLayout() {
        var mainPanelLayout = new GroupLayout(this);

        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(logoPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(inputPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(logoPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent e) { OnClick_SignUp(loginField, passwordField, passwordRepeatField); }
}