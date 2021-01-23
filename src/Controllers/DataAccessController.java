package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import java.util.HashMap;

public class DataAccessController {

    public static HashMap<String, String> GetStudentByCNE(String CNE){
        HashMap<String, String> studentData = new HashMap<>();

        System.out.println("Getting the Student data from DB ..");
        studentData.put("CNE", "CNEGoesHere");
        return studentData;
    }
    public static boolean UserNotFound(String CNE){ return true;}

}
