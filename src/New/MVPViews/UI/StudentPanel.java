package New.MVPViews.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static New.MVPViews.OutputView.*;
import static javax.swing.GroupLayout.*;

public class StudentPanel extends JPanel implements IPanel, ActionListener {
    //<editor-fold desc="Variables Declarations">">
    private final JPanel logoPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JSeparator cinSeparator = new JSeparator();
    private final JSeparator apogeSeparator = new JSeparator();
    private final JSeparator emailSeparator = new JSeparator();
    private final JLabel logoIconLabel = new JLabel(new ImageIcon("Resources/library_120px.png"));
    private final JLabel logoTextLabel = new JLabel("Request Manager");
    private final JLabel cinLabel = new JLabel("CIN");
    private final JLabel apogeLabel = new JLabel("N°Apoge");
    private final JLabel emailLabel = new JLabel("Email");
    private final JButton submitButton = new JButton("Submit");
    private final JButton closeButton = new JButton("X");
    private final JRadioButton transcriptRadioB = new JRadioButton("Transcript");
    private final JRadioButton certificateRadioB = new JRadioButton("Certificate");
    private final JTextField cinField = new JTextField();
    private final JTextField apogeField = new JTextField();
    private final JTextField emailField = new JTextField();
    //</editor-fold>

    public StudentPanel() {
        SetupLogoPanel();
        SetupInputPanel();
        SetupMainPanelLayout(logoPanel, inputPanel, this);
    }

    //<editor-fold desc="Logo Panel">
    private void SetupLogoPanel() {
        logoPanel.setBackground(PICKLED_BLUEWOOD);
        SetupLogoPanelLayout(logoPanel, logoIconLabel, logoTextLabel);
        SetupLogoTextPanel();
    }
    private void SetupLogoTextPanel() {
        logoTextLabel.setForeground(BLUE_BAYOUX);
        logoTextLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 24));
    }
    //</editor-fold>

    private void SetupInputPanel() {
        inputPanel.setBackground(BLUE_BAYOUX);
        SetupLabels(cinLabel, apogeLabel, emailLabel);
        SetupInputFields(cinField, apogeField, emailField);
        SetupSeparators(cinSeparator, apogeSeparator, emailSeparator);
        SetupRadioButtons(transcriptRadioB, certificateRadioB);
        SetupSubmitButton(submitButton, this, true,"Click to creat an account");
        SetupCloseButton(closeButton);
        SetupInputPanelLayout();
    }
    private void SetupLabels(JLabel... labels) {
        for (JLabel label : labels) {
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            label.setForeground(BLUE_HAZE);
            label.setBackground(BLUE_BAYOUX);
        }
    }
    private void SetupRadioButtons(JRadioButton... radioButtons) {
        for (JRadioButton radioButton : radioButtons) {
            radioButton.setBackground(BLUE_BAYOUX);
            radioButton.setForeground(BLUE_HAZE);
            radioButton.addActionListener(this);
        }
    }
    private void SetupInputPanelLayout() {
        var inputPanelLayout = new GroupLayout(inputPanel);

        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                .addComponent(submitButton, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(174, 174, 174))))
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(transcriptRadioB)
                                                .addGap(41, 41, 41)
                                                .addComponent(certificateRadioB))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                                .addGap(73, 73, 73)
                                                                .addComponent(emailLabel)
                                                                .addGap(28, 28, 28))
                                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                                                .addComponent(cinLabel)
                                                                                .addGap(34, 34, 34))
                                                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                                                                .addComponent(apogeLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(cinSeparator)
                                                                .addComponent(cinField)
                                                                .addComponent(apogeField)
                                                                .addComponent(apogeSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE))
                                                        .addGroup(Alignment.TRAILING, inputPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(emailField)
                                                                .addComponent(emailSeparator, Alignment.TRAILING, PREFERRED_SIZE, 226, PREFERRED_SIZE)))))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(cinField, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                        .addComponent(cinLabel))
                                .addComponent(cinSeparator, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(apogeField, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                        .addComponent(apogeLabel))
                                .addGap(0, 0, 0)
                                .addComponent(apogeSeparator, PREFERRED_SIZE, 13, PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(emailField, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                        .addComponent(emailLabel))
                                .addGap(0, 0, 0)
                                .addComponent(emailSeparator, PREFERRED_SIZE, 13, PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(inputPanelLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(transcriptRadioB)
                                        .addComponent(certificateRadioB))
                                .addGap(18, 18, 18)
                                .addComponent(submitButton, DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(123, 123, 123))
        );
    }

    @Override
    public JPanel GetPanel() { return this; }
    @Override
    public void Activate(){ this.setVisible(true);}
    @Override
    public void Deactivate(){ this.setVisible(false);}
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(submitButton))
            System.out.println("form submitted");
        else if (event.getSource().equals(transcriptRadioB))
            certificateRadioB.setSelected(false);
        else if (event.getSource().equals(certificateRadioB))
            transcriptRadioB.setSelected(false);
    }
}