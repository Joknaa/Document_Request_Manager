package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Views.OutputView;

public class OutputController {

    public static void DisplayMainMenu(){ OutputView.DisplayMainMenu(); }
    public static void DisplayStudentSpaceMenu(){ OutputView.DisplayStudentSpaceMenu(); }
    public static void DisplayAdminSpaceMenu(){ OutputView.DisplayAdminSpaceMenu(); }
    public static void DisplayRequestConfirmationMenu(){ OutputView.DisplayRequestConfirmationMenu(); }

    public static void DisplayError(String error) { OutputView.DisplayError(error); }
    public static void DisplayMessage(String message) { OutputView.DisplayMessage(message); }

}