package Utuls;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public static void sendMail(String recepient,String messageEnvoye) throws Exception{
        Properties propreies = new Properties();

        propreies.setProperty("mail.smtp.starttls.enable", "true");
        propreies.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        propreies.put("mail.smtp.auth","true");
        propreies.put("mail.smtp.starttls.enable","true");
        propreies.put("mail.smtp.host","smtp.gmail.com");
        propreies.put("mail.smtp.port","587");

        String myAccount = "abdoycode@gmail.com";
        String password = "vjtowiewyveriuhu";

        Session session = Session.getDefaultInstance(propreies, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount,password);
            }

        });
        Message message = prepareMessage(session,myAccount,recepient,messageEnvoye);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session,String myAccountMail,String recepient,String messageEnvoye){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Your Password Is : ===> ");
            message.setText(messageEnvoye);
            return message;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
