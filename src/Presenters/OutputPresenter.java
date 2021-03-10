package Presenters;

import Views.OutputView;
import java.sql.SQLException;
import static Presenters.DataBasePresenter.*;
import static Presenters.RequestPresenter.*;

public class OutputPresenter {
    public static void SetUpGUI(){ OutputView.SetUpGUI(); }

    public static String[] Try_FillList() { return GetRequestsList(); }
    public static String[] Try_GetRequestDescription(String requestName) {
        String[] requestDescription = {"", "", "", ""};
        try {
            requestDescription = GetRequestDescription(requestName);
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError(e.getMessage());
        }
        return requestDescription;
    }

    public static void LogOut() { UserPresenter.LogOut(); }
    public static String GetCurrentUser() { return UserPresenter.GetCurrentUser(); }
    public static void DisplayError(String error) { OutputView.DisplayError(error);}
}
