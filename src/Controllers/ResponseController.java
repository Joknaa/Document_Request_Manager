package ENSA.GenieLogiciel.Project.GLProject.src.Controllers;

import ENSA.GenieLogiciel.Project.GLProject.src.Models.EmailResponseModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.IDocumentModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.IResponseModel;
import ENSA.GenieLogiciel.Project.GLProject.src.Models.RequestModel;

public class ResponseController {

    public static void SendResponse(RequestModel targetRequest){
        if (targetRequest.IsAccepted()){
            SendAcceptanceRespond(targetRequest.GetEmail(), targetRequest.GetDocument());
        } else {
            SendDenialResponse();
        }
    }

    private static void SendAcceptanceRespond(String emailAddress, IDocumentModel document) {
        IResponseModel email = new EmailResponseModel(emailAddress);
        email.SendDocument(document);
    }
    private static void SendDenialResponse() {
        IResponseModel email = new EmailResponseModel();
        email.SendError("Request Declined !");
    }
}
