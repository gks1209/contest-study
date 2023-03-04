package com.example.conteststudy.email;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailOffice365 {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private static final String SERVIDOR_SMTP = "smtp.office365.com";
    private static final int PORTA_SERVIDOR_SMTP = 587;
    private static final String CONTA_PADRAO = "mail@mail.com.br";
    private static final String SENHA_CONTA_PADRAO = "password*";

    private final String from = "gkswhdtn@office.skhu.ac.kr";
    private final String To = "";

    private final String subject = "[이메일 인증] 인증코드";
    private final String messageContent = "인증코드 : ";

    private String randomCode() { // 사용자에게 보낼 임의의 숫자 4-6자리 구해서 반환
        Random random = new Random();
        int createNum = 0;
        String ranNum;
        int letter = 6;
        String resultNum = "";

        for (int i = 0; i<letter; i++) {
            createNum = random.nextInt(9);
            ranNum = Integer.toString(createNum);
            resultNum += ranNum;
        }
        return resultNum;
    }

    private void saveCode(String reciever, String code) {
        // 코드 DB 저장
    }

    public void sendEmail(String to) { //받는 사람을 파라미터로 받아야함
        final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);
            }

        });

        String code = randomCode();

        try {
            final Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(messageContent + code);
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
            LOGGER.log(Level.WARNING, "Error ao enviar mensagem: " + ex.getMessage(), ex);
        } finally {
            saveCode(to, code);
        }
    }

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        return config;
    }

    public static void main(final String[] args) {
        new SendEmailOffice365().sendEmail();
    }

}
