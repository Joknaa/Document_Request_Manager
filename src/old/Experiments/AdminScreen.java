package old.Experiments;
import static old.Experiments.OutputView.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen implements IMenu{
    private static final JPanel adminPanel = new JPanel();
    private static final JButton button = new JButton("back");
    private static JTable table = new JTable();

    public JPanel GetPanel() { return adminPanel; }
    public void Display(JFrame appFrame){
        SetupPanel();
        appFrame.add(adminPanel);
        //appFrame.add(new JScrollPane(table));
        appFrame.setTitle("Espace Administrateur");
    }
    private static void SetupPanel() {
        adminPanel.removeAll();
        SetupTable();
        button.addActionListener(new OnClick_SwapFrames(adminMenu, mainMenu));
        adminPanel.add(new JScrollPane(table));
        adminPanel.add(button, BorderLayout.SOUTH);
    }
    private static void SetupTable() {
        table = new JTable();


        //The solution that I suggest is selecting a row (capturing the ID of the row) then choosing to validate or refuse
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {"bill","Hazel","Male","Hazel","Hazel"},
                        {"Samaka","Dyali","Ana","Dyali","Dyali"},
                        {"Fia","FDF","plz","Fia","Fia"},
                        {"Salam","Cava","alik","Cava","Cava"},
                },

                new String[] {"Email", "N° Apogée","CIN", "Type demande", "L'envoi d'email"}
        ){
            /**
             * (
             */
            private static final long serialVersionUID = 1L;
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        JButton validerDemande = new JButton("Valider");
        validerDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // need to be finished
            }
        });
        JButton refuserDemande = new JButton("Refuser");
        refuserDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // need to be finished
            }
        });
        table.setBounds(20,120,200,50);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
    }
}
    /*private static JLabel session = new JLabel("Session: Admin ");
    private static JLabel titleTable = new JLabel("Liste des demandes: ");


        session.setBounds(20, 20, 100, 25);
        f.add(session);

        titleTable.setBounds(20, 40, 100, 25);
        f.add(titleTable); */