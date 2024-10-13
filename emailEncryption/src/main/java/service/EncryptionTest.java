package service;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EncryptionTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = "secret-password";
        String salt = "12345678";

        // Instantiate the EncryptionService
        EncryptionService encryptionService = new EncryptionService(password, salt);

        // Define two test emails
        String validEmail = "hackuta@gmail.com";
        String passwordEmail = "hackuta";

        String message = "Hello from HackUTA";
        String encryptedMessage = encryptionService.encrypt(message);
        System.out.println("Encrypted Message " + encryptedMessage);

        while(true){
            System.out.println("What is your email?");
            Scanner in = new Scanner(System.in);
            String email = in.nextLine();
            System.out.println("What is your password?");
            String passwordGiven = in.nextLine();

            if(email.equals(validEmail) && passwordGiven.equals(passwordEmail)){
                System.out.println("Your password is correct");
                break;
            }
            else {
                System.out.println("Invalid");
            }
        }



        // Define the message to encrypt

        // Test with the valid email
        if (isValidEmail(validEmail)) {
            // Call on the instance
            System.out.println("Encrypted Message for " + validEmail + ": " + encryptedMessage);
            String decryptedMessage = encryptionService.decrypt(encryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);
        } else {
            System.out.println("Invalid email: " + validEmail + ". No encryption performed.");
        }



    }

    // Email validation method using a simple regex pattern
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
