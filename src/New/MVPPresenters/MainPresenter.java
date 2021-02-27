package New.MVPPresenters;

import java.sql.SQLException;

import static New.MVPPresenters.DataBasePresenter.*;
import static New.MVPPresenters.OutputPresenter.*;

public class MainPresenter {
    public static void start() {
        Try_SetupDataBaseConnection();
        SetUpGUI();
    }

    private static void Try_SetupDataBaseConnection(){
        try {
            SetupDataBaseConnection();
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError("Ops !! You can't connect to the DataBase\n");
            System.exit(1);
        }
    }
}

