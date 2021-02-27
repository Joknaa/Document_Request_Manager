package old.Controllers;

import static old.Controllers.DataAccessController.*;
import static old.Controllers.DocumentController.*;
import static old.Controllers.InputController.Try_GetStringInput;
import static old.Controllers.OutputController.*;
import static old.Controllers.InputController.*;
import old.Models.RequestModel;
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

    public static void Try_AddRequest() {
        try {
            AddRequest();
        } catch (InvalidDocumentException | UserNotFoundException | IncorrectRequestDataException exception){
            DisplayError(exception.getMessage());
        }
    }
    private static void AddRequest() throws UserNotFoundException, InvalidDocumentException, IncorrectRequestDataException {
        GetRequestData();
        CheckDocumentAvailable(requestData.get("DocumentType"));
        CheckUserExist(requestData.get("CNE"));
        studentData = GetStudent_RequestRelatedData(requestData.get("CNE"));
        CheckDataIsCorrect();
        RegistreRequest();
    }
    public static void Try_DisplayRequests(){
        try {
            DisplayRequests();
        } catch (NoRequestsFoundException requestsNotFound){
            DisplayError(requestsNotFound.getMessage());
        }
    }
    private static void DisplayRequests() throws NoRequestsFoundException {
        if (requestsList.isEmpty()) throw new NoRequestsFoundException("There is no requests to display");
        for (RequestModel request : requestsList.values()) {
            DisplayMessage(request.GetDetails());
        }
    }
    public static void Try_ManageRequests(){
        try {
            ManageRequests();
        } catch (NoRequestsFoundException requestNotFound) {
            DisplayError(requestNotFound.getMessage());
        }
    }
    private static void ManageRequests() throws NoRequestsFoundException{
        RequestModel targetRequest = SelectRequest();
        DisplayMessage(targetRequest.GetDetails());
        ConfirmeRequest(targetRequest);
    }

    private static RequestModel SelectRequest() throws NoRequestsFoundException{
        DisplayMessage("Enter the Request ID: ");
        String ID = Try_GetStringInput();
        if (requestsList.containsKey(ID))
            return requestsList.get(ID);

        throw new NoRequestsFoundException("No request Found with this ID !");
    }
    private static void ConfirmeRequest(RequestModel targetRequest) {
        DisplayRequestConfirmationMenu();
        option = Try_GetIntInput();
        ApplyOption(option, targetRequest);
        ResponseController.SendResponse(targetRequest);
    }
    private static void ApplyOption(int option, RequestModel targetRequest) {
        switch (option) {
            case 1 -> AcceptRequest(targetRequest);
            case 2 -> DeclineRequest(targetRequest);
            case 0 -> BackToMainMenu();
        }
    }

    private static void AcceptRequest(RequestModel targetRequest) { targetRequest.SetAccepted(true); }
    private static void DeclineRequest(RequestModel targetRequest) {
        targetRequest.SetAccepted(false);
    }
    private static void BackToMainMenu() { option = 0; }

    private static void GetRequestData() {
        DisplayMessage("Fill the form(Email, CNE, CIN, DocType): ");
        String[] input = try_GetRequestData();
        for (int i = 0; i < requestRequirement.length; i++) {
            requestData.put(requestRequirement[i], input[i]);
        }
    }
    private static void CheckDocumentAvailable(String docType) throws InvalidDocumentException {
        DocumentController.CheckDocumentAvailable(docType);
    }
    private static void CheckDataIsCorrect() throws IncorrectRequestDataException {
        for (int i = 0; i < requestRequirement.length - 1; i++) { // '- 1' bcs the comparison does not include the DocumentType
            if (RequestData_DoesNotMatch_FetchedData(requestRequirement[i])){
                throw new IncorrectRequestDataException("Request Data doesnt match DB data");
            }
        }
    }
    private static boolean RequestData_DoesNotMatch_FetchedData(String key) {
        return !requestData.get(key).trim().equalsIgnoreCase(studentData.get(key));
    }

    private static void RegistreRequest() {
        String UniqueID = GenerateUniqueID();
        String CNE = requestData.get("CNE");
        String email = requestData.get("email");
        String DocumentType = requestData.get("DocumentType");

        requestsList.put(UniqueID, new RequestModel(
                UniqueID,
                CNE,
                email,
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

    static class IncorrectRequestDataException extends Exception {public IncorrectRequestDataException(String s) {super(s);}}
    static class NoRequestsFoundException extends Exception { public NoRequestsFoundException(String s) {super(s);}}
}