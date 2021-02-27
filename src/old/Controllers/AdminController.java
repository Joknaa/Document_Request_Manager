package old.Controllers;

import static old.Controllers.InputController.*;
import static old.Controllers.OutputController.*;
import old.Models.AdminModel;

import java.util.HashMap;

public class AdminController {
    private static final HashMap<String, AdminModel> adminLists = new HashMap<>();

    public static boolean Authenticate(){
        adminLists.put("login", new AdminModel("admin", "admin"));
        String[] credentials = GetCredentials();
        if (!CredentialsExist(credentials)){
            DisplayError("Incorrect Login or Password");
            return false;
        } else {
            return true;
        }
    }

    private static boolean CredentialsExist(String[] credentials) {
        for (AdminModel admin : adminLists.values() ) {
            if (admin.GetLogin().equals(credentials[0]) && admin.GetPassword().equals(credentials[1])){
                return true;
            }
        }
        return false;
    }
    private static String[] GetCredentials() {
        DisplayMessage("Enter the Login and Password: ");
        return new String[] {Try_GetStringInput(), Try_GetStringInput()};
    }

}
