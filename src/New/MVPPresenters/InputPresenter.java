package New.MVPPresenters;

import static New.MVPPresenters.DataBasePresenter.*;
import static New.MVPViews.OutputView.*;
import New.MVPViews.UI.MainPanel;
import java.sql.SQLException;

public class InputPresenter {
    public static void Try_SignUp(String login, String password, String passwordRepeat) {
        try {
            Check_NoEmptyFieldsExist(login, password, passwordRepeat);
            Check_PasswordMatch(password, passwordRepeat);
            SignUp(login, password);
            DisplayInformation("Welcome " + login + " ! You Signed Up Successfully !");
            OnClick_SwapPanels(new MainPanel());
        } catch (ClassNotFoundException | SQLException | EmptyInputFieldException |
                PasswordMismatchException | UserAlreadyExistException | InputTooShortException e ) {
            DisplayError(e.getMessage());
        }
    }
    public static void Check_NoEmptyFieldsExist(String... inputFields) throws EmptyInputFieldException, InputTooShortException {
        for (String field : inputFields ) {
            if (field.isEmpty()) throw new EmptyInputFieldException("Pls fill all the fields");
            if (field.length() <= 3) throw new InputTooShortException("Login and Password should be at least 3 characters");
        }
    }
    public static void Check_PasswordMatch(String password, String passwordRepeat) throws PasswordMismatchException{
        if (!password.equals(passwordRepeat))
            throw new PasswordMismatchException("Password doesnt match");
    }
    public static void Try_SignIn(String login, String password) {
        try {
            Check_NoEmptyFieldsExist(login, password);
            SignIn(login, password);
            DisplayInformation("Welcome " + login + " !");
            OnClick_SwapPanels(new MainPanel());
        } catch (EmptyInputFieldException | SQLException | ClassNotFoundException |
                UserNotFoundException | InputTooShortException e) {
            DisplayError(e.getMessage());
        }
    }

    public static void Try_ManageRequest(boolean accepted, String requestName) {
        try {
            ManageRequest(requestName, accepted);
        } catch (SQLException | ClassNotFoundException | NullPointerException e){
            DisplayError(e.getMessage());
        }
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class InputTooShortException extends Exception { InputTooShortException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}
