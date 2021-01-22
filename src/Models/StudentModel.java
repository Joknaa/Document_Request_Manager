package ENSA.GenieLogiciel.Project.GLProject.src.Models;

public class StudentModel {
    private int CNE;
    private String CIN;
    private String firstName;
    private String lastName;
    private String email;

    StudentModel(){}
    public StudentModel(int CNE, String CIN, String fName, String lName, String email){
        SetCNE(CNE);
        SetCIN(CIN);
        SetFistName(fName);
        SetLastName(lName);
        SetEmail(email);
    }

    public void SetCNE(int cne){ this.CNE = cne;}
    public int GetCNE(){ return this.CNE;}

    public void SetCIN(String CIN){ this.CIN = CIN;}
    public String GetCIN(){ return this.CIN;}

    public void SetFistName(String firstName){ this.firstName = firstName;}
    public String GetFistName(){ return this.firstName;}

    public void SetLastName(String lastName){ this.lastName = lastName;}
    public String GetLastName(){ return this.lastName;}

    public void SetEmail(String email){ this.email = email;}
    public String GetEmail(){ return this.email;}

    public String GetDetails(){
        return String.format("=> Name: '%s %s' | ApogeeID: '%d' | CIN: '%s' | Email: '%s'",
                this.GetFistName(),
                this.GetLastName(),
                this.GetCNE(),
                this.GetCIN(),
                this.GetEmail());
    }

}
