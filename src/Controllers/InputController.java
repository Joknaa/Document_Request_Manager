package GLProject.src.Controllers;

import static GLProject.src.Controllers.OutputController.*;
import GLProject.src.Views.InputView;
import java.util.InputMismatchException;

public class InputController {

    public static int Try_GetIntInput(){
        int input = -1;
        try {
            input = InputView.GetIntInput();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: int");
            ClearInputBuffer();
        }
        return input;
    }
    public static String Try_GetStringInput(){
        String input = "";
        try {
            input = InputView.GetStringInput();
        } catch (InputMismatchException WrongInput){
            DisplayError("Wrong Input type ! Please Enter: String");
            ClearInputBuffer();
        }
        return input;
    }

    public static String[] try_GetRequestData(){
        return new String[] {
                Try_GetStringInput(),
                Try_GetStringInput(),
                Try_GetStringInput(),
                Try_GetStringInput()};
    }

    private static void ClearInputBuffer(){ InputView.ClearInputBuffer(); }
}