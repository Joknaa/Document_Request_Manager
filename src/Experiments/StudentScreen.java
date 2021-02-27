package Experiments;

import static Experiments.OutputView.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//todo; check the size of te button submit request
public class StudentScreen implements IMenu{
    private static final JPanel panel = new JPanel();
    private static final JLabel titlePage = new JLabel("Renseigner le formulaire suivant pour demander un document: ");
    private static final JLabel emailLabel = new JLabel("Adresse email: ");
    private static final JTextField emailText = new JTextField(300);
    private static final JLabel nApogeeLabel = new JLabel("N° Apogée: ");
    private static final JTextField nApogeeText = new JTextField(300);
    private static final JLabel cinLabel = new JLabel("CIN: ");
    private static final JTextField cinText = new JTextField(300);
    private static final JLabel docLabel = new JLabel("Choix du document: ");
    private static final JButton submitButton = new JButton("Envoyer la demande");
    private static final JButton BackButton = new JButton("Back");
    private static final JRadioButton docOption1 = new JRadioButton("Attestation de scolarité");
    private static final JRadioButton docOption2 = new JRadioButton("Relevé de notes");

    public JPanel GetPanel(){ return SetupPanel(); }
    public void Display(JFrame appFrame) {
        SetupPanel();
        appFrame.add(panel);
        appFrame.setTitle("Espace Etudiant");
    }
    private static JPanel SetupPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        SetupComponent(titlePage, 10, 20, 500, 40);
        SetupComponent(emailLabel,50, 60, 250, 25);
        SetupComponent(emailText, 150, 60, 250, 26);
        SetupComponent(nApogeeLabel, 50, 100, 250, 25);
        SetupComponent(nApogeeText, 150, 100, 250, 26);
        SetupComponent(cinLabel, 50, 140, 250, 25);
        SetupComponent(cinText, 150, 140, 250, 26);
        SetupComponent(docLabel, 50, 180, 250, 25);
        SetupComponent(docOption1, 200,180,200,26);
        SetupComponent(docOption2, 400,180,200,26);
        SetupComponent(submitButton, 205, 220, 150, 30);

        panel.add(BackButton);

        docOption1.addActionListener(new OnSelectOptionAction());
        docOption2.addActionListener(new OnSelectOptionAction());
        submitButton.addActionListener(new OnClick_SwapFrames(studentMenu, adminMenu));
        BackButton.addActionListener(new OnClick_SwapFrames(studentMenu, mainMenu));
        return panel;
    }
    private static void SetupComponent(JComponent Component,int x, int y, int w, int h) {
        Component.setBounds(x, y, w, h);
        panel.add(Component);
    }

    static class OnSelectOptionAction implements ActionListener {
        OnSelectOptionAction(){ }

        @Override
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (docOption1.equals(source)) {
                docOption2.setSelected(false);
            } else if (docOption2.equals(source)) {
                docOption1.setSelected(false);
            }
        }
    }
    static class OnSubmitAction implements ActionListener {
        OnSubmitAction(){ }

        @Override
        public void actionPerformed(ActionEvent event) {
            // Store the request data ..
        }
    }
}