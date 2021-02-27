package Models;

import static Controllers.OutputController.*;

public class EmailResponseModel implements IResponseModel{
    private String email;

    public EmailResponseModel(){}
    public EmailResponseModel(String email){
        SetEmail(email);
    }

    public void SetEmail(String email){ this.email = email;}
    public String GetEmail(){ return this.email;}

    @Override
    public void SendDocument(String email, IDocumentModel document) {
        DisplayMessage(String.format("Sending to '%s': %s",email, document.GetDetails()));
    }
    @Override
    public void SendError(String email, String error) {
        DisplayError(String.format("Sending to '%s': Request Declined !",email));
    }
}
