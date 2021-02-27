package Controllers;

import Models.StudentModel;
import java.util.HashMap;

public class StudentController {
    private static final HashMap<String, StudentModel> students = new HashMap<>();

    public static void CreateStudentModel(String CNE, HashMap<String, String> studentData) {
        students.put(CNE, new StudentModel(studentData));
    }
    public static StudentModel GetStudentModel(String CNE) { return students.get(CNE); }

}
