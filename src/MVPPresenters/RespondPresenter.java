package MVPPresenters;

import MVPModels.Documents;
import MVPModels.FileMail;
import MVPModels.TextMail;
import javax.mail.MessagingException;
import static MVPPresenters.DocumentPresenter.*;
import static MVPPresenters.OutputPresenter.Try_GetRequestDescription;
import static MVPViews.OutputView.DisplayError;
import static MVPViews.OutputView.DisplayInformation;

public class RespondPresenter {
    public static void Respond(Documents requestedDocument, String requestName, boolean accepted)  {
        try {
            String[] requestData = Try_GetRequestDescription(requestName);
            SendEmail(requestData, accepted, requestedDocument, requestName);
        } catch (Exception e){
            DisplayError(e.getMessage());
        }
    }

    private static void SendEmail(String[] requestData, boolean accepted, Documents requestedDocument, String requestName) throws MessagingException {
        String email = requestData[2];

        if (accepted){
            CreateDocument(requestedDocument, requestData, requestName);
            FileMail fileEmail = new FileMail();
            fileEmail.setupServerProperties();
            fileEmail.SendEmail("Resources/Documents/Transcript/Transcript.pdf",email,"Document Demandé");
            fileEmail.SendingDetails();
        } else {
            TextMail textEmail = new TextMail();
            textEmail.MailSend("mohammadlaadidaoui@hotmail.com","Votre demande a été refusé","Réponse de Demande");
        }
        DisplayInformation("Email Sent !");
    }
}
