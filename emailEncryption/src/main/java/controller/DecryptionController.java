package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EncryptionService;

@RestController
@RequestMapping("/api/decrypt")
public class DecryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @GetMapping
    public String decryptMessage(@RequestParam String encryptedMessage) {
        return encryptionService.decrypt(encryptedMessage);
    }
}
