package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.StudentModel;

import java.util.HashMap;

public class StudentController {
    private static HashMap<String, StudentModel> students = new HashMap<>();

    public static void CreateStudentModel(String CNE, HashMap<String, String> studentData) {
        System.out.println("Creating Student Model .. ");

        students.put(CNE, new StudentModel(studentData));
    }

}
