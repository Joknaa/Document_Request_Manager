package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import java.util.HashMap;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;

public class RequestController {
    private static final HashMap<String, String> requestData = new HashMap<>();
    public static void GetRequest() {
        DisplayMessage("Fill the form(Email, CNE, CIN, DocType): ");
        GetRequestData();

        if (DataIsCorrect()){
            DisplayMessage("Request Approved");
        } else{
            DisplayError("Incorrect Data");
        }
    }

    private static boolean DataIsCorrect() {
        String CNE = requestData.get("CNE");
        StudentController.FetchStudentData(CNE);
        return true;

    }

    private static void GetRequestData() {
        requestData.put("Email", InputController.Try_GetStringInput());
        requestData.put("CNE", InputController.Try_GetStringInput());
        requestData.put("CIN", InputController.Try_GetStringInput());
        requestData.put("DocumentType", InputController.Try_GetStringInput());
    }


}
