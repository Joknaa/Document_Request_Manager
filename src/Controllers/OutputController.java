package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Views.OutputView;

public class OutputController {

    public static void DisplayMainMenu(){ OutputView.DisplayMainMenu(); }
    public static void DisplayRequestSpaceMenu(){ OutputView.DisplayRequestSpaceMenu(); }

    public static void DisplayError(String error) { OutputView.DisplayError(); }
    public static void DisplayMessage(String message) { OutputView.DisplayMessage(message); }

}
