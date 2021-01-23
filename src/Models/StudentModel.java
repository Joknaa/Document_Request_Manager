package ENSA.GenieLogiciel.Project.GLProject.src.Models;

import java.util.HashMap;

public class StudentModel {
    private final HashMap<String, String> StudentData = new HashMap<>();

    StudentModel(){}
    public StudentModel(String CNE, String CIN, String fName, String lName, String email){
        SetCNE(CNE);
        SetCIN(CIN);
        SetFistName(fName);
        SetLastName(lName);
        SetEmail(email);
    }

    public void SetCNE(String CNE){ this.StudentData.put("CNE", CNE);}
    public String GetCNE(){ return this.StudentData.get("CNE");}

    public void SetCIN(String CIN){ this.StudentData.put("CIN", CIN);}
    public String GetCIN(){ return this.StudentData.get("CIN");}

    public void SetFistName(String firstName){ this.StudentData.put("firstName", firstName);}
    public String GetFistName(){ return this.StudentData.get("firstName");}

    public void SetLastName(String lastName){ this.StudentData.put("lastName", lastName);}
    public String GetLastName(){ return this.StudentData.get("lastName");}

    public void SetEmail(String email){ this.StudentData.put("email", email);}
    public String GetEmail(){ return this.StudentData.get("email");}

    public static void GetStudentDate() { }

    public String GetDetails(){
        return String.format("=> Name: '%s %s' | ApogeeID: '%s' | CIN: '%s' | Email: '%s'",
                this.GetFistName(),
                this.GetLastName(),
                this.GetCNE(),
                this.GetCIN(),
                this.GetEmail());
    }

}
