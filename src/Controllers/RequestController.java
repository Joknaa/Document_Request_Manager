package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DataAccessController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import java.util.HashMap;

public class RequestController {
    private static final HashMap<String, String> requestData = new HashMap<>();
    private static HashMap<String, String> studentData = new HashMap<>();
    public static void AddRequest() {
        DisplayMessage("Fill the form(Email, CNE, CIN, DocType): ");
        StoreRequestData();

        if (DataIsCorrect()){
            DisplayMessage("Request Approved");
        } else{
            DisplayError("Incorrect Data");
        }
    }

    private static boolean DataIsCorrect() {
        String CNE = requestData.get("CNE");
        if (UserNotFound(CNE)) return false;

        StudentController.CreateStudentModel(CNE, GetStudentByCNE(CNE));
        return true;

    }

    private static void StoreRequestData() {
        requestData.replaceAll((k, v) -> InputController.Try_GetStringInput());
    }
}
