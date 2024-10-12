package service;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    // TextEncryptor is a class for AES encryption
    private final TextEncryptor textEncryptor;

    public EncryptionService(String password, String salt) {
        this.textEncryptor = Encryptors.text(password, salt);
    }
    public String encrypt(String text) {
        return textEncryptor.encrypt(text);
    }

    public String decrypt(String encryptedText) {
        return textEncryptor.decrypt(encryptedText);
    }
}
