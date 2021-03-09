package DocCreationTest;

import MVPModels.FileMail;
import MVPModels.TextMail;

import javax.mail.MessagingException;

public class main {

    public static void main(String[] args) throws MessagingException {
        TextMail t = new TextMail();
        //t.MailSend("ayoubyam@gmail.com","SALAM","AVIS");
        FileMail f = new FileMail();
        // i am testing here file sending
        // keep this order of methods calling
        f.setupServerProperties();
        f.SendEmail("Resources/Documents/Transcript/Transcript.pdf","mohaozomaki.ml@gmail.com","test Transcript");
        f.SendingDetails();
    }
}
