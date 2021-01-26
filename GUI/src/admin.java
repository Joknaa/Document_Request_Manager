import javax.swing.*;
import java.awt.*;



public class admin extends JFrame{
    JTable table;

    public admin(){
        setLayout(new FlowLayout());

        String[] columnNames =  {"Type demande","Email","N° Apogée","CIN","L'envoi d'email"};

        Object[][] data = {
                {"bill","Hazel","Male","Hazel","Hazel"},
                {"Samaka","Dyali","Ana","Dyali","Dyali"},
                {"Fia","FDF","plz","Fia","Fia"},
                {"Salam","Cava","alik","Cava","Cava"},
        };

        table = new JTable(data, columnNames);
        table.setBounds(20,120,200,50);

        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void showTable(){
        admin gui = new admin();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600,400);
        gui.setVisible(true);
        gui.setTitle("Espace Administrateur");
    }
    public static void main(String[] args) {
        showTable();
    }

}


    /*private static JLabel session = new JLabel("Session: Admin ");
    private static JLabel titleTable = new JLabel("Liste des demandes: ");


        session.setBounds(20, 20, 100, 25);
        f.add(session);

        titleTable.setBounds(20, 40, 100, 25);
        f.add(titleTable); */

