package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EncryptionService encryptionService;

    public void sendEncryptedEmail(String to, String subject, String message) {
        // Encrypt the email message
        String encryptedMessage = encryptionService.encrypt(message);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(encryptedMessage);
        mailSender.send(mailMessage);
    }
}
