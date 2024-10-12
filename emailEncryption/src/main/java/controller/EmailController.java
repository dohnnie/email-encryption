package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message) {

        emailService.sendEncryptedEmail(to, subject, message);
        return "Email sent successfully!";
    }
}
