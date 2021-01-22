package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.StudentModel;

public class MainController {
    public static void Run(){
        int Option = 1;
        while (Option != 0) {
            OutputController.DisplayMainMenu();
            Option = InputController.Try_GetIntInput();
            ApplyOption(Option);
        }
    }
    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> RequestSpaceController.ManageRequests();
            case 2 -> AdminSpaceController.ManageRequests();
            case 0 -> ExitProgram();
        }
    }

    private static void ExitProgram(){ System.exit(0); }
    private static void GetStudentDetails(StudentModel student1) {
        System.out.println(student1.GetDetails());
    }
}
