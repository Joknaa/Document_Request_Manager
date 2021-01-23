package ENSA.GenieLogiciel.Project.GLProject.src.Models;

import java.util.HashMap;

public class AdminModel {
    private final HashMap<String, String> adminData = new HashMap<>();

    public AdminModel(){}
    public AdminModel(String login, String password){
        SetLogin(login);
        SetPassword(password);
    }
    public AdminModel(HashMap<String, String> adminData){
        SetLogin(adminData.get("CNE"));
        SetPassword(adminData.get("CIN"));
    }

    public void SetLogin(String login){ this.adminData.put("login", login);}
    public String GetLogin(){ return this.adminData.get("login");}

    public void SetPassword(String password){ this.adminData.put("password", password);}
    public String GetPassword(){ return this.adminData.get("password");}
}
