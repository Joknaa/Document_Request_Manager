package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Views.InputView;
import java.util.InputMismatchException;

public class InputController {

    public static int Try_GetIntInput(){
        int input = -1;
        try {
            input = InputView.GetIntInput();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: int");
        }
        return input;
    }

    public static String Try_GetStringInput(){
        String input = "";
        try {
            input = InputView.GetStringInput();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: String");
        }
        return input;
    }


    private static void DisplayError(String error) {
        OutputController.DisplayError(error);
    }
}
