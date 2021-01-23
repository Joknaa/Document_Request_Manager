package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DataAccessController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import java.util.HashMap;

public class RequestController {
    private static final String[] requestRequirement = {"email", "CNE", "CIN", "DocumentType"};
    private static final HashMap<String, String> requestData = new HashMap<>();
    private static HashMap<String, String> studentData = new HashMap<>();

    public static void AddRequest() {
        DisplayMessage("Fill the form(Email, CNE, CIN, DocType): ");
        StoreRequestData();
        String CNE = requestData.get("CNE");
        if (UserNotFound(CNE)) {
            DisplayError("Incorrect Data");
            return;
        }

        studentData = GetStudent_RequestRelatedData_ByCNE(CNE);
        if (DataIsIncorrect()){
            DisplayError("Incorrect Data");
        } else{
            DisplayMessage("Request Approved");
        }
    }

    private static boolean DataIsIncorrect() {
        for (int i = 0; i < requestRequirement.length - 1; i++) { // '- 1' bcs the comparison does not include the DocumentType
            if (RequestData_DoesNotMatch_FetchedData(requestRequirement[i])){
                return true;
            }
        }
        return false;
    }
    private static boolean RequestData_DoesNotMatch_FetchedData(String key) {
        return !requestData.get(key).equalsIgnoreCase(studentData.get(key));
    }
    private static void StoreRequestData() {
        String[] input = InputController.try_GetRequestData();
        for (int i = 0; i < requestRequirement.length; i++) {
            requestData.put(requestRequirement[i], input[i]);
        }
    }
}
