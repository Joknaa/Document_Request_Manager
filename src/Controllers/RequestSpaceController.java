package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.InputController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.RequestController.*;

public class RequestSpaceController {
    private static int option = 1;

    public static void ManageRequests() {
        while (option != 0) {
            DisplayRequestSpaceMenu();
            option = Try_GetIntInput();
            ApplyOption(option);
        }
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> GetRequest();
            case 0 -> BackToMainMenu();
        }
    }

    private static void BackToMainMenu() { option = 0; }
}
