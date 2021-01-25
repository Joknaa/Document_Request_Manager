package GLProject.src.Controllers;

public class MainController {
    public static void Run(){
        int Option = 1;
        DatabaseController.dbConnection();
        while (Option != 0) {
            OutputController.DisplayMainMenu();
            Option = InputController.Try_GetIntInput();
            ApplyOption(Option);
        }
    }
    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> StudentSpaceController.ShowStudentSpace();
            case 2 -> AdminSpaceController.ShowAdminSpace();
            case 0 -> ExitProgram();
        }
    }
    private static void ExitProgram(){ System.exit(0); }
}
