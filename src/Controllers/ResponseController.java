package GLProject.src.Controllers;

import GLProject.src.Models.EmailResponseModel;
import GLProject.src.Models.IDocumentModel;
import GLProject.src.Models.IResponseModel;
import GLProject.src.Models.RequestModel;

public class ResponseController {

    public static void SendResponse(RequestModel targetRequest){
        if (targetRequest.IsAccepted()){
            SendAcceptanceRespond(targetRequest.GetEmail(), targetRequest.GetDocument());
        } else {
            SendDenialResponse(targetRequest.GetEmail());
        }
    }

    private static void SendAcceptanceRespond(String emailAddress, IDocumentModel document) {
        IResponseModel email = new EmailResponseModel(emailAddress);
        email.SendDocument(emailAddress, document);
    }
    private static void SendDenialResponse(String emailAddress) {
        IResponseModel email = new EmailResponseModel();
        email.SendError(emailAddress,"Request Declined !");
    }
}
