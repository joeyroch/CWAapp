package com.example.joey.screen;



import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import android.util.Log;
import java.util.List;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
/**
 * Created by Joey on 4/17/2016.
 */
public class SendGmailMsg {

    final String emailPort = "587";
    final String smtpAuth = "true";
    final String starttls = "true";
    final String emailHost = "smtp.gmail.com";

    String fromEmail;
    String fromPassword;
    final String toEmail = "joey.rochford97@gmail.com";
    String emailSubject;
    String emailBody;

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public SendGmailMsg(){

    }

    public  SendGmailMsg(String fromEmail, String fromPassword, String emailSubject, String emailBody){

        this.fromEmail = fromEmail;
        this.fromEmail = fromPassword;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);
        Log.i("GMail", "Mail server properties set.");
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.user", fromEmail);
        props.put("mail.smtp.password", fromPassword);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");


    }


    public MimeMessage createEmailMessage() throws AddressException, MessagingException, UnsupportedEncodingException{



        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.user", fromEmail);
        props.put("mail.smtp.password", fromPassword);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");


         mailSession = Session.getDefaultInstance(emailProperties, null);
       // mailSession = Session.getInstance(props, new GMailAuthenticator(fromEmail, fromPassword));
        emailMessage = new MimeMessage(mailSession);

        emailMessage.setFrom(new InternetAddress(fromEmail, fromEmail));
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email
        Log.i("GMail", "Email Message created.");
        return emailMessage;
    }

    public void sendEmail() throws AddressException, MessagingException {

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromEmail, fromPassword);
        Log.i("GMail", "allrecipients: " + emailMessage.getAllRecipients());
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        Log.i("GMail", "Email sent successfully.");
    }
}
