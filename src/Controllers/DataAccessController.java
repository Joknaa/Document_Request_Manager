package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.StudentController.*;
import java.util.HashMap;

public class DataAccessController {

    public static HashMap<String, String> GetStudent_RequestRelatedData_ByCNE(String CNE){
        HashMap<String, String> fetchedStudentData = new HashMap<>();

        System.out.println("Getting the Student data from DB ..");
        GetStudentDataFromDB(CNE, fetchedStudentData);
        CreateStudentModel(CNE, fetchedStudentData);
        return GetStudentModel(CNE).GetRequestRelatedData();
    }
    private static void GetStudentDataFromDB(String CNE, HashMap<String, String> fetchedStudentData) {
        fetchedStudentData.put("CNE", "cne");
        fetchedStudentData.put("CIN", "cin");
        fetchedStudentData.put("firstName", "firstname");
        fetchedStudentData.put("lastName", "lastname");
        fetchedStudentData.put("email", "email");
    }
    public static boolean UserNotFound(String CNE){ return false;}
}
