package Controllers;

import Models.LogStatus;
import static Controllers.InputController.*;
import static Controllers.OutputController.*;
import static Controllers.RequestController.*;

public class AdminSpaceController {
    private static LogStatus adminLogStatus = LogStatus.LoggedOut;
    private static int option = 1;

    public static void ShowAdminSpace() {
        Authenticate();
        while (option != 0) {
            if (adminLogStatus == LogStatus.LoggedIn) AccessAdminMenu();
            else BackToMainMenu();
        }
        option = 1;
    }

    private static void Authenticate() {
        if (adminLogStatus == LogStatus.LoggedOut){
            adminLogStatus = AdminController.Authenticate() ? LogStatus.LoggedIn : LogStatus.LoggedOut;
        }
    }

    private static void AccessAdminMenu() {
        DisplayAdminSpaceMenu();
        option = Try_GetIntInput();
        ApplyOption(option);
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> Try_ManageRequests();
            case 2 -> Try_DisplayRequests();
            case 3 -> Logout();
            case 0 -> BackToMainMenu();
        }
    }

    private static void Logout() { adminLogStatus = LogStatus.LoggedOut; }
    private static void BackToMainMenu() { option = 0; }
}
