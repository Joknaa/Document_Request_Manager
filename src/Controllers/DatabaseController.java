package GLProject.src.Controllers;

import GLProject.src.Models.DatabaseModel;
import javax.swing.*;
import java.sql.*;

public class DatabaseController {
    static DatabaseModel pog = new DatabaseModel();

    public static void dbConnection() {
        //We can add later a feature to input the credentials of the database instead per exemple: * url = pog.setdbUrl(scanner.next()); *
        //but I guess it's not necessary, we can just write them like this in the source code let's not complicate things
        pog.setdbUrl("jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        pog.setdbUsername("root");
        pog.setDbPassword("");

        try {
            Connection conn = DriverManager.getConnection(pog.getdbUrl(),pog.getdbUrl(),pog.getdbPassword()) ;
            Statement stmt = conn.createStatement();
            String query = "select * from admin;";
            ResultSet rs = stmt.executeQuery(query);
            if ( rs.next() ) {
                JOptionPane.showMessageDialog(null, "La base de donn\u00E9es est charg\u00E9 avec succ�s !", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Probl�me du chargement de la base de donn\u00E9es !\nVeuillez d\u00E9marrez le serveur mysql avant de lancer l'application\n"+ e,"Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}