package ENSA.GenieLogiciel.Project.GLProject.src.Models;

import static ENSA.GenieLogiciel.Project.GLProject.src.Controllers.OutputController.*;

public class EmailResponseModel implements IResponseModel{
    private String email;

    public EmailResponseModel(){}
    public EmailResponseModel(String email){
        SetEmail(email);
    }

    public void SetEmail(String email){ this.email = email;}
    public String GetEmail(){ return this.email;}

    @Override
    public void SendDocument(IDocumentModel document) {
        DisplayMessage(String.format("Sending: %s",document.GetDetails()));
    }
    @Override
    public void SendError(String error) {
        DisplayError(error);
    }
}