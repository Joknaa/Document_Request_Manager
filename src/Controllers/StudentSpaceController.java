package Controllers;

import static Controllers.OutputController.*;
import static Controllers.InputController.*;
import static Controllers.RequestController.*;

public class StudentSpaceController {
    private static int option = 1;

    public static void ShowStudentSpace() {
        while (option != 0) {
            DisplayStudentSpaceMenu();
            option = Try_GetIntInput();
            ApplyOption(option);
        }
        option = 1;
    }

    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> Try_AddRequest();
            case 2 -> Try_DisplayRequests();
            case 0 -> BackToMainMenu();
        }
    }

    private static void BackToMainMenu() { option = 0; }
}