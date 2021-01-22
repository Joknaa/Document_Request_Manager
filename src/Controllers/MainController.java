package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.RequestModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.SchoolCertificateModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.TranscriptModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.StudentModel;
import ENSA.OOP.TP1.*;

public class MainController {
    public static void Run(){
        int Option = 1;
        while (Option != 0) {
            OutputController.DisplayMainMenu();
            Option = InputController.Try_GetIntInput();
            ApplyOption(Option);
        }

        RequestModel demande1 = new RequestModel(1, 12345, new TranscriptModel(1));
        System.out.println(demande1.GetDetails());

        RequestModel demande2 = new RequestModel(2, 67890, new SchoolCertificateModel(2));
        System.out.println(demande2.GetDetails());

        StudentModel oknaa = new StudentModel(16097678, "JM70889", "mohammad", "laadidaoui", "mohaozomaki.ml@gmail.com");

        GetStudentDetails(oknaa);
    }
    private static void ApplyOption(int option) {
        switch (option) {
            case 1 -> RequestSpaceController.ManageRequests();
            case 2 -> AdminSpaceController.ManageRequests();
            case 0 -> ExitProgram();
        }
    }

    private static void ExitProgram(){ System.exit(0); }
    private static void GetStudentDetails(StudentModel student1) {
        System.out.println(student1.GetDetails());
    }
}
