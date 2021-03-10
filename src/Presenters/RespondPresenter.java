package Presenters;

import Models.Documents;
import Models.FileMail;
import Models.TextMail;
import javax.mail.MessagingException;
import static Presenters.DocumentPresenter.*;
import static Presenters.OutputPresenter.Try_GetRequestDescription;
import static Views.OutputView.DisplayError;
import static Views.OutputView.DisplayInformation;

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
