package Models;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// this class for sending an email in form of a file (like an attachement)
// contact.hellosew@gmail.com is the sender

public class FileMail {
    Session newSession=null;
    MimeMessage mimeMessage=null;

    public void SendingDetails() throws MessagingException {
        String fromUser="apogeensate@gmail.com";
        String fromUserPassowrd="Ensate123";
        String emailHost="smtp.gmail.com";
        Transport transport=newSession.getTransport("smtp");
        transport.connect(emailHost,fromUser,fromUserPassowrd);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

    public void SendEmail(String path, String recepteur, String sujet) {
        try {
            File file=new File(path);
            FileDataSource datasource1 = new FileDataSource(file);
            DataHandler handler1 = new DataHandler(datasource1);
            MimeBodyPart autruche = new MimeBodyPart();

            autruche.setDataHandler(handler1);
            autruche.setFileName(datasource1.getName());

            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(autruche);

            mimeMessage=new MimeMessage(newSession);
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.setSubject(sujet);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recepteur));

            MimeBodyPart bodypart=new MimeBodyPart();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void setupServerProperties() {
        Properties properties=System.getProperties();
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.starttls.enable","true");
        newSession = Session.getDefaultInstance(properties,null);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
    }
}

