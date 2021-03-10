package Views;

import static Presenters.OutputPresenter.*;
import static Presenters.InputPresenter.*;

import Models.Documents;
import Presenters.OutputPresenter;

import static Presenters.RequestPresenter.RemoveRequest;
import static javax.swing.GroupLayout.*;
import static javax.swing.JOptionPane.*;

import Presenters.RespondPresenter;
import Views.UI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class OutputView {
    private static boolean listSelectionListener_IsActive = true;
    private static final AppFrame appFrame = new AppFrame();
    public static final Color PICKLED_BLUEWOOD = new Color(52, 66, 91);
    public static final Color BLUE_BAYOUX = new Color(76, 96, 133);
    public static final Color BLUE_HAZE = new Color(190, 200, 218);
    public static final IPanel mainPanel = new MainPanel();
    public static final IPanel loginPanel = new LoginPanel();
    public static final IPanel signUpPanel = new SignupPanel();
    public static final IPanel studentPanel = new StudentPanel();
    public static final IPanel startingPanel = new StartingPanel();

    public static void SetUpGUI() {
        appFrame.SetupOnTimeConfiguration();
        appFrame.SetCurrentPanel(new StartingPanel());
    }

    //<editor-fold desc="On-Event Actions">
    public static void OnClick_Logout(){
        LogOut();
        OnClick_SwapPanels(startingPanel);
    }
    public static void OnClick_SignUp(JTextField login, JTextField password, JTextField passwordRepeat) {
        String strLogin = login.getText().trim();
        String strPassword = password.getText().trim();
        String strPasswordRepeat = passwordRepeat.getText().trim();
        Try_SignUp(strLogin, strPassword, strPasswordRepeat);
    }
    public static void OnClick_SignIn(JTextField login, JPasswordField password){
        String strLogin = login.getText();
        String strPassword = String.valueOf(password.getPassword());
        Try_SignIn(strLogin, strPassword);
    }
    public static void OnClick_SwapPanels(IPanel gotoPanel){
        appFrame.GetCurrentPanel().setVisible(false);
        appFrame.SetCurrentPanel(gotoPanel);
    }

    public static void OnListSelection_UpdateDescription(String requestName, JTable descriptionTable) {
        if (!listSelectionListener_IsActive) return;

        String[] documentDescription = Try_GetRequestDescription(requestName);

        descriptionTable.getCellEditor(0, 1);
        descriptionTable.setValueAt(documentDescription[0], 0, 1);
        descriptionTable.setValueAt(documentDescription[1], 1, 1);
        descriptionTable.setValueAt(documentDescription[2], 2, 1);
        descriptionTable.setValueAt(documentDescription[3], 3, 1);
    }
    public static void OnClick_ManageRequest(boolean accepted, JList<String> list, DefaultListModel<String> listModel){
        String requestName = list.getSelectedValue();

        Documents requestedDocument = Try_ManageRequest(accepted, requestName);
        RemoveRequest_WhileListenerDisabled(listModel, requestName);
        RespondPresenter.Respond(requestedDocument, requestName, accepted);
        RemoveRequest(requestName);
    }
    public static void OnHover_SwapIcons(JLabel label, String newImageURL){
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setIcon(new ImageIcon(newImageURL));

    }
    public static void OnClick_SaveRequest(JTextField cinField, JTextField apogeField, JTextField emailField,
                                           JRadioButton transcriptRB){
        String cin = cinField.getText().trim();
        String apoge = apogeField.getText().trim();
        String email = emailField.getText().trim();
        Try_SaveRequest(cin, apoge, email, transcriptRB.isSelected());
    }
    //</editor-fold>

    //<editor-fold desc="Setting up Common JFrame Components">
    public static void SetupCloseButton(JButton closeButton){
        closeButton.setBackground(BLUE_BAYOUX);
        closeButton.setFont(new java.awt.Font("Source Code Pro", Font.PLAIN, 24));
        closeButton.setForeground(PICKLED_BLUEWOOD);
        closeButton.setText("X");
        closeButton.setToolTipText("Close");
        closeButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setFocusable(false);
        closeButton.setMaximumSize(new java.awt.Dimension(100, 38));
        closeButton.setMinimumSize(new java.awt.Dimension(100, 38));
        closeButton.setPreferredSize(new java.awt.Dimension(100, 38));
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        closeButton.addMouseListener(new OnMouseClick_CloseApp());
    }
    public static void SetupSubmitButton(JButton submitButton, ActionListener actionListener, boolean isEnabled, String toolTip) {
        //todo: add some feed back on clicking the buttons
        submitButton.setBorder(BorderFactory.createLineBorder(BLUE_HAZE));
        submitButton.setPreferredSize(new Dimension(100, 38));
        submitButton.setMaximumSize(new Dimension(100, 38));
        submitButton.setMinimumSize(new Dimension(100, 38));
        submitButton.setBackground(BLUE_BAYOUX);
        submitButton.setForeground(BLUE_HAZE);
        submitButton.setToolTipText(toolTip);
        submitButton.setEnabled(isEnabled);
        submitButton.setContentAreaFilled(false);
        submitButton.setFocusPainted(false);
        submitButton.setFocusable(false);
        submitButton.setOpaque(false);
        submitButton.addActionListener(actionListener);
    }
    public static void SetupSeparators(JSeparator... separators) {
        for (JSeparator separator : separators) {
            separator.setBackground(BLUE_HAZE);
        }
    }
    public static void SetupInputFields(JTextField... inputFields) {
        for (JTextField inputField : inputFields) {
            inputField.setBackground(BLUE_BAYOUX);
            inputField.setForeground(BLUE_HAZE);
            inputField.setBorder(null);
        }
    }
    public static void SetupLogoPanelLayout(JPanel logoPanel, JLabel LogoIconPanel, JLabel LogoTextPanel) {
        var logoPanelLayout = new GroupLayout(logoPanel);

        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
                logoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(LogoIconPanel)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
                                .addContainerGap(122, Short.MAX_VALUE)
                                .addComponent(LogoTextPanel)
                                .addGap(118, 118, 118))
        );
        logoPanelLayout.setVerticalGroup(
                logoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addContainerGap(138, Short.MAX_VALUE)
                                .addComponent(LogoIconPanel)
                                .addGap(18, 18, 18)
                                .addComponent(LogoTextPanel)
                                .addGap(193, 193, 193))
        );
    }
    public static void SetupMainPanelLayout(JPanel leftHalf, JPanel rightHalf, JPanel hostPanel) {
        var mainPanelLayout = new GroupLayout(hostPanel);

        hostPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(leftHalf, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rightHalf, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(leftHalf, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightHalf, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    public static void SetupHeaderTextArea(JTextArea textArea) {
        textArea.setEditable(false);
        textArea.setBackground(PICKLED_BLUEWOOD);
        textArea.setColumns(5);
        textArea.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
        textArea.setForeground(BLUE_BAYOUX);
        textArea.setRows(1);
        textArea.setTabSize(1);
        textArea.setAutoscrolls(false);
        textArea.setFocusable(false);
    }
    public static void EmptyAllFields(JComponent... components) {
        for(JComponent comp : components) {
            if(comp instanceof JTextField)
                ((JTextField) comp).setText("");
            else if (comp instanceof JRadioButton)
                ((JRadioButton) comp).setSelected(false);
            else if (comp instanceof JButton)
                comp.setEnabled(false);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Displaying Dialog Windows">
    public static void DisplayInformation(String greeting) {
        showMessageDialog(null, greeting, "Greeting", INFORMATION_MESSAGE);
    }
    public static void DisplayError(String error) {
        showMessageDialog(null, error, "Error", ERROR_MESSAGE);
    }
    public static int DisplayConfirmation() {
        return JOptionPane.showConfirmDialog(null, "You sure you wanna delete this ?",
                "Confirmation", YES_NO_OPTION);
    }
    //</editor-fold>

    private static void RemoveRequest_WhileListenerDisabled(DefaultListModel<String> listModel, String requestName) {
        listSelectionListener_IsActive = false;
        listModel.removeElement(requestName);
        listSelectionListener_IsActive = true;
    }
    public static String[] GetListContent() {
        String[] listContent = Try_FillList();
        Arrays.sort(listContent);
        return listContent;
    }
    public static String GetCurrentUser(){ return OutputPresenter.GetCurrentUser(); }

    public static class OnMouseClick_CloseApp extends MouseAdapter { public void mouseClicked(MouseEvent e) { System.exit(0); }}
}