package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.InputController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.RequestController.*;

public class AdminSpaceController {
    private static int option = 1;

    public static void ShowAdminSpace() {
        while (option != 0) {
            DisplayAdminSpaceMenu();
            option = Try_GetIntInput();
            ApplyOption(option);
        }
        option = 1;
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> ManageRequests();
            case 2 -> DisplayRequests();
            case 0 -> BackToMainMenu();
        }
    }

    private static void BackToMainMenu() { option = 0; }
}
