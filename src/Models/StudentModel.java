package GLProject.src.Models;

import java.util.HashMap;

public class StudentModel {
    private final HashMap<String, String> studentData = new HashMap<>();

    public StudentModel(){}
    public StudentModel(String CNE, String CIN, String fName, String lName, String email){
        SetCNE(CNE);
        SetCIN(CIN);
        SetFistName(fName);
        SetLastName(lName);
        SetEmail(email);
    }
    public StudentModel(HashMap<String, String> studentData){
        SetCNE(studentData.get("CNE"));
        SetCIN(studentData.get("CIN"));
        SetFistName(studentData.get("firstName"));
        SetLastName(studentData.get("lastName"));
        SetEmail(studentData.get("email"));
    }

    public void SetCNE(String CNE){ this.studentData.put("CNE", CNE);}
    public String GetCNE(){ return this.studentData.get("CNE");}

    public void SetCIN(String CIN){ this.studentData.put("CIN", CIN);}
    public String GetCIN(){ return this.studentData.get("CIN");}

    public void SetFistName(String firstName){ this.studentData.put("firstName", firstName);}
    public String GetFistName(){ return this.studentData.get("firstName");}

    public void SetLastName(String lastName){ this.studentData.put("lastName", lastName);}
    public String GetLastName(){ return this.studentData.get("lastName");}

    public void SetEmail(String email){ this.studentData.put("email", email);}
    public String GetEmail(){ return this.studentData.get("email");}

    public HashMap<String, String> GetRequestRelatedData() {
        HashMap<String, String> requestRelatedData = new HashMap<>();

        requestRelatedData.put("email", studentData.get("email"));
        requestRelatedData.put("CNE", studentData.get("CNE"));
        requestRelatedData.put("CIN", studentData.get("CIN"));
        return requestRelatedData; }

    public HashMap<String, String> GetAllData() { return studentData; }

    public String GetDetails(){
        return String.format("=> Name: '%s %s' | ApogeeID: '%s' | CIN: '%s' | Email: '%s'",
                this.GetFistName(),
                this.GetLastName(),
                this.GetCNE(),
                this.GetCIN(),
                this.GetEmail());
    }

}
