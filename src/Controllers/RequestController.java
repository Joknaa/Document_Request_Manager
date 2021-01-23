package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DataAccessController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.DocumentController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;
import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.InputController.*;
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
    private static int option = 1;

    public static void AddRequest() {
        GetRequestData();

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
    public static void ManageRequests(){
        RequestModel targetRequest = SelectRequest();

        if (targetRequest == null){
            DisplayError("Request Not Found");
            return;
        }

        ConfirmeRequest(targetRequest);
    }

    private static RequestModel SelectRequest() {
        DisplayMessage("Enter the Request ID: ");
        return requestsList.get(Try_GetStringInput());
    }
    private static void ConfirmeRequest(RequestModel targetRequest) {
        DisplayRequestConfirmationMenu();
        option = Try_GetIntInput();
        ApplyOption(option, targetRequest);
    }
    private static void ApplyOption(int option, RequestModel targetRequest) {
        switch (option) {
            case 1 -> AcceptRequest(targetRequest);
            case 2 -> DeclineRequest(targetRequest);
            case 0 -> BackToMainMenu();
        }
    }

    private static void AcceptRequest(RequestModel targetRequest) {
        DisplayMessage("Request Accepted");
        targetRequest.SetAccepted(true);
    }
    private static void DeclineRequest(RequestModel targetRequest) {
        DisplayMessage("Request Declined");
        targetRequest.SetAccepted(false);
    }
    private static void BackToMainMenu() { option = 0; }

    private static void GetRequestData() {
        DisplayMessage("Fill the form(Email, CNE, CIN, DocType): ");
        String[] input = InputController.try_GetRequestData();
        for (int i = 0; i < requestRequirement.length; i++) {
            requestData.put(requestRequirement[i], input[i]);
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
        return !requestData.get(key).trim().equalsIgnoreCase(studentData.get(key));
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
}
