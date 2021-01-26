import javax.swing.*;
import java.awt.*;

public class etu {

    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JLabel titlePage = new JLabel("Renseigner le formulaire suivant pour demander un document: ");
    private static JLabel emailLabel = new JLabel("Adresse email: ");
    private static JTextField emailText = new JTextField(300);
    private static JLabel nApogeeLabel = new JLabel("N° Apogée: ");
    private static JTextField nApogeeText = new JTextField(300);
    private static JLabel cinLabel = new JLabel("CIN: ");
    private static JTextField cinText = new JTextField(300);
    private static JLabel docLabel = new JLabel("Choix du document: ");
    private static JButton button = new JButton("Envoyer la demande");



    public static void main(String[] args) {
        showPage();
    }

    public static void showPage() {
        frame.setSize(700,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titlePage.setBounds(10, 20, 500, 40);
        panel.add(titlePage);


        frame.setTitle("Espace Etudiant");
        frame.add(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);


        emailLabel.setBounds(50, 60, 250, 25);
        panel.add(emailLabel);


        emailText.setBounds(150, 60, 250, 26);
        panel.add(emailText);


        nApogeeLabel.setBounds(50, 100, 250, 25);
        panel.add(nApogeeLabel);


        nApogeeText.setBounds(150, 100, 250, 26);
        panel.add(nApogeeText);

        cinLabel.setBounds(50, 140, 250, 25);
        panel.add(cinLabel);


        cinText.setBounds(150, 140, 250, 26);
        panel.add(cinText);


        docLabel.setBounds(50, 180, 250, 25);
        panel.add(docLabel);

        JRadioButton r1=new JRadioButton("Attestation de scolarité");
        JRadioButton r2=new JRadioButton("Relevé de notes");

        r1.setBounds(200,180,200,26);
        r2.setBounds(400,180,200,26);

        panel.add(r1);
        panel.add(r2);


        button.setBounds(205, 220, 150, 30);
        //button.setBackground(Color.green);
        panel.add(button);


        frame.setVisible(true);
    }

}

