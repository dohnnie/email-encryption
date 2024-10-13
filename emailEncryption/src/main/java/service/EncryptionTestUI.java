package service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class EncryptionTestUI {
    private static EncryptionService encryptionService;
    private static String validEmail = "hackuta@gmail.com";
    private static String passwordEmail = "hackuta";

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Encryption Test UI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Email Label and Text Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 30, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 30, 200, 30);

        // Password Label and Text Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 200, 30);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 130, 100, 30);

        // Output Area
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 180, 300, 70);
        outputArea.setEditable(false);

        // Add components to frame
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(submitButton);
        frame.add(outputArea);

        // Initialize the EncryptionService
        String password = "secret-password";
        String salt = "12345678";
        encryptionService = new EncryptionService(password, salt);

        // Action listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String passwordGiven = new String(passwordField.getPassword());
                String message = "Hello from HackUTA";

                if (isValidEmail(email)) {
                    if (email.equals(validEmail) && passwordGiven.equals(passwordEmail)) {
                        String encryptedMessage = encryptionService.encrypt(message);
                        String decryptedMessage = encryptionService.decrypt(encryptedMessage);
                        outputArea.setText("Encrypted Message: " + encryptedMessage + "\nDecrypted Message: " + decryptedMessage + "\nPassword is correct!");
                    } else {
                        outputArea.setText("Invalid email or password.");
                    }
                } else {
                    outputArea.setText("Invalid email format.");
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    // Email validation method using regex
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}

