package New.MVPViews.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static New.MVPViews.OutputView.*;
import static javax.swing.GroupLayout.*;

public class StartingPanel extends JPanel implements IPanel, ActionListener {
    //<editor-fold desc="Variables Declarations">
    private final JPanel studentLogoPanel = new JPanel();
    private final JPanel teacherLogoPanel = new JPanel();
    private final JLabel studentLogo = new JLabel(new ImageIcon("Resources/student_male2_127px BAYOUX.png"));
    private final JLabel headerLogo = new JLabel(new ImageIcon("Resources/library_120px.png"));
    private final JLabel teacherLogo = new JLabel(new ImageIcon("Resources/teacher2_127px.png"));
    private final JTextArea headerTextArea = new JTextArea("Request\nManager");
    private final JButton closeButton = new JButton("X");
    //</editor-fold>

    public StartingPanel() {
        SetupStudentLogoPanel();
        SetupTeacherLogoPanel();
        SetupMainPanelLayout(studentLogoPanel, teacherLogoPanel, this);
    }

    private void SetupStudentLogoPanel() {
        studentLogoPanel.setBackground(PICKLED_BLUEWOOD);
        SetupStudentLogo();
        SetupStudentLogoPanelLayout();
    }
    private void SetupStudentLogo() {
        studentLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) { OnClick_SwapPanels(studentPanel); }
        });
    }
    public void SetupStudentLogoPanelLayout() {
        var studentLogoPanelLayout = new GroupLayout(studentLogoPanel);

        studentLogoPanel.setLayout(studentLogoPanelLayout);
        studentLogoPanelLayout.setHorizontalGroup(
                studentLogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, studentLogoPanelLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headerLogo)
                                .addContainerGap())
                        .addGroup(studentLogoPanelLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(studentLogo)
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        studentLogoPanelLayout.setVerticalGroup(
                studentLogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(studentLogoPanelLayout.createSequentialGroup()
                                .addComponent(headerLogo)
                                .addGap(92, 92, 92)
                                .addComponent(studentLogo)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void SetupTeacherLogoPanel() {
        teacherLogoPanel.setBackground(BLUE_BAYOUX);
        setupTeacherLogo();
        SetupCloseButton(closeButton);
        SetupHeaderTextArea();
        SetupTeacherInputPanelLayout();
    }

    private void setupTeacherLogo() {
        teacherLogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) { OnClick_SwapPanels(loginPanel); }
        });
    }

    private void SetupHeaderTextArea() {
        headerTextArea.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
        headerTextArea.setForeground(PICKLED_BLUEWOOD);
        headerTextArea.setBackground(BLUE_BAYOUX);
        headerTextArea.setAutoscrolls(false);
        headerTextArea.setFocusable(false);
        headerTextArea.setEditable(false);
        headerTextArea.setTabSize(1);
        headerTextArea.setColumns(5);
        headerTextArea.setRows(1);
    }
    private void SetupTeacherInputPanelLayout() {
        var teacherLogoPanelLayout = new GroupLayout(teacherLogoPanel);

        teacherLogoPanel.setLayout(teacherLogoPanelLayout);
        teacherLogoPanelLayout.setHorizontalGroup(
                teacherLogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, teacherLogoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerTextArea, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeButton, PREFERRED_SIZE, 21, PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                        .addGroup(teacherLogoPanelLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(teacherLogo)
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        teacherLogoPanelLayout.setVerticalGroup(
                teacherLogoPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(teacherLogoPanelLayout.createSequentialGroup()
                                .addGroup(teacherLogoPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(teacherLogoPanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(closeButton, PREFERRED_SIZE, 23, PREFERRED_SIZE))
                                        .addGroup(teacherLogoPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(headerTextArea, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                .addGap(104, 104, 104)
                                .addComponent(teacherLogo)
                                .addContainerGap(162, Short.MAX_VALUE))
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
        if (event.getSource().equals(studentLogo)) OnClick_SwapPanels(studentPanel);
        else if (event.getSource().equals(teacherLogo)) OnClick_SwapPanels(loginPanel);
    }
}