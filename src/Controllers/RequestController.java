package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DataAccessController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DocumentController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.RequestModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestController {
    private static final String[] requestRequirement = {"email", "CNE", "CIN", "DocumentType"};
    private static final List<Integer> ExistingIDs = new ArrayList<>();
    private static final HashMap<String, RequestModel> requestsList = new HashMap<>();
    private static final HashMap<String, String> requestData = new HashMap<>();
    private static HashMap<String, String> studentData;

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
            RegistreRequest();
        }
    }
    public static void DisplayRequests(){
        for (RequestModel request : requestsList.values()) {
            DisplayMessage(request.GetDetails());
        }
    }
    private static void RegistreRequest() {
        String UniqueID = GenerateUniqueID();
        String CNE = requestData.get("CNE");
        String DocumentType = requestData.get("DocumentType");

        requestsList.put(UniqueID, new RequestModel(
                UniqueID,
                CNE,
                GetDocumentInstance(DocumentType)));
    }
    private static String GenerateUniqueID(){
        int ID;
        do {
            ID = (int) Math.floor(Math.random() * 10000);
        } while (ExistingIDs.contains(ID));
        ExistingIDs.add(ID);
        return String.format("%d", ID);
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
        return !requestData.get(key).trim().equalsIgnoreCase(studentData.get(key));
    }
    private static void StoreRequestData() {
        String[] input = InputController.try_GetRequestData();
        for (int i = 0; i < requestRequirement.length; i++) {
            requestData.put(requestRequirement[i], input[i]);
        }
    }
}
