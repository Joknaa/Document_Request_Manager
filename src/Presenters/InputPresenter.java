package Presenters;

import static Presenters.DataBasePresenter.*;
import static Views.OutputView.*;

import Models.Documents;
import Views.UI.MainPanel;
import java.sql.SQLException;

public class InputPresenter {
    public static void Try_SignUp(String login, String password, String passwordRepeat) {
        try {
            Check_NoEmptyFieldsExist(login, password, passwordRepeat);
            Check_InputTooShort(login, password, passwordRepeat);
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
        }
    }
    private static void Check_InputTooShort(String... inputFields) throws InputTooShortException {
        for (String field : inputFields ) {
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
    public static void Try_SaveRequest(String cin, String apoge, String email, boolean isTranscript) {
        try {
            Check_NoEmptyFieldsExist(cin, apoge, email);
            Documents selectedDocument = isTranscript ? Documents.Transcript : Documents.Certificate;
            SaveRequest(cin, apoge, email, selectedDocument);
            DisplayInformation("Request submitted !");
        } catch (EmptyInputFieldException | SQLException | ClassNotFoundException | InputTooShortException e) {
            DisplayError(e.getMessage());
        }
    }

    public static Documents Try_ManageRequest(boolean accepted, String requestName) {
        String docType;
        try {
            docType = ManageRequest(requestName, accepted);
        } catch (SQLException | ClassNotFoundException | NullPointerException e){
            DisplayError(e.getMessage());
            docType = "None";
        }
        return docType.equals("Certificate") ? Documents.Certificate :
                docType.equals("Transcript") ? Documents.Transcript : Documents.None;
    }

    public static class EmptyInputFieldException extends Exception { EmptyInputFieldException(String s){ super(s);}}
    public static class InputTooShortException extends Exception { InputTooShortException(String s){ super(s);}}
    public static class PasswordMismatchException extends Exception { PasswordMismatchException(String s){ super(s);}}
}
