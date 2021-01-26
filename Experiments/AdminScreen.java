package GLProject.Experiments;

import javax.swing.*;
import java.awt.*;

public class AdminScreen{
    private static final JFrame adminFrame = new JFrame();

    public static void Display(){
        //adminFrame.setLayout(new FlowLayout());
        JTable table = SetupTable();

        adminFrame.add(new JScrollPane(table));
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(600,400);
        adminFrame.setTitle("Espace Administrateur");
        adminFrame.setVisible(true);
    }

    private static JTable SetupTable() {
        String[] columnNames =  {"Type demande","Email","N° Apogée","CIN","L'envoi d'email"};
        Object[][] data = {
                {"bill","Hazel","Male","Hazel","Hazel"},
                {"Samaka","Dyali","Ana","Dyali","Dyali"},
                {"Fia","FDF","plz","Fia","Fia"},
                {"Salam","Cava","alik","Cava","Cava"},
        };
        JTable table = new JTable(data, columnNames);

        table.setBounds(20,120,200,50);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        return table;
    }
}
    /*private static JLabel session = new JLabel("Session: Admin ");
    private static JLabel titleTable = new JLabel("Liste des demandes: ");


        session.setBounds(20, 20, 100, 25);
        f.add(session);

        titleTable.setBounds(20, 40, 100, 25);
        f.add(titleTable); */