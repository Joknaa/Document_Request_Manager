package Controllers;

import static Controllers.OutputController.DisplayError;
import static Controllers.StudentController.*;
import java.util.HashMap;

public class DataAccessController {

    public static HashMap<String, String> GetStudent_RequestRelatedData(String CNE){
        HashMap<String, String> fetchedStudentData = new HashMap<>();

        System.out.println("Getting the Student data from DB ..");
        Try_GetStudentDataFromDB(CNE, fetchedStudentData);
        CreateStudentModel(CNE, fetchedStudentData);
        return GetStudentModel(CNE).GetRequestRelatedData();
    }
    private static void Try_GetStudentDataFromDB(String CNE, HashMap<String, String> fetchedStudentData) {
        try {
            GetStudentDataFromDB(CNE, fetchedStudentData);
        } catch (Exception e){
            DisplayError("There is a error in the DB");
        }
    }
    private static void GetStudentDataFromDB(String CNE, HashMap<String, String> fetchedStudentData) {
        fetchedStudentData.put("CNE", "cne");
        fetchedStudentData.put("CIN", "cin");
        fetchedStudentData.put("firstName", "firstname");
        fetchedStudentData.put("lastName", "lastname");
        fetchedStudentData.put("email", "email");
    }

    public static void CheckUserExist(String CNE) throws UserNotFoundException{ }

    static class UserNotFoundException extends Exception {
        public UserNotFoundException(String s) { super(s);}
    }
}
