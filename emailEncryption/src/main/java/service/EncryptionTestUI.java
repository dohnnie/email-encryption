package service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EncryptionTestUI {
    private static EncryptionService encryptionService;
    private static String validEmail = "hackuta@gmail.com";
    private static String passwordEmail = "hackuta";
    private static List<String> messageList = new ArrayList<>();
    private static List<String> encryptedMessages = new ArrayList<>();

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Encryption Test UI");
        frame.setSize(600, 500);
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

        // Message List Label
        JLabel messageListLabel = new JLabel("Encrypted Messages:");
        messageListLabel.setBounds(400, 30, 150, 30);

        // Message List (Encrypted Messages)
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> messageJList = new JList<>(listModel);
        JScrollPane messageScrollPane = new JScrollPane(messageJList);
        messageScrollPane.setBounds(400, 60, 150, 150);

        // Decrypted Message Label and Text Area
        JLabel decryptedLabel = new JLabel("Decrypted Message:");
        decryptedLabel.setBounds(50, 230, 150, 30);
        JTextArea decryptedArea = new JTextArea();
        decryptedArea.setBounds(50, 260, 500, 150);
        decryptedArea.setLineWrap(true);
        decryptedArea.setWrapStyleWord(true);
        decryptedArea.setEditable(false);

        // Add components to frame
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(submitButton);
        frame.add(messageListLabel);
        frame.add(messageScrollPane);
        frame.add(decryptedLabel);
        frame.add(decryptedArea);

        // Initialize the EncryptionService
        String password = "secret-password";
        String salt = "12345678";
        encryptionService = new EncryptionService(password, salt);

        // Create some messages to encrypt
        messageList.add("Hi from HackUTA");
        messageList.add("Welcome to the Encryption System");
        messageList.add("This is a secure message");
        messageList.add("Enjoy the Hackathon!");

        // Encrypt messages and populate the list
        for (String message : messageList) {
            String encryptedMessage = encryptionService.encrypt(message);
            encryptedMessages.add(encryptedMessage);
            listModel.addElement(encryptedMessage);
        }

        // Action listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String passwordGiven = new String(passwordField.getPassword());
                int selectedIndex = messageJList.getSelectedIndex();

                if (isValidEmail(email)) {
                    if (email.equals(validEmail) && passwordGiven.equals(passwordEmail)) {
                        if (selectedIndex != -1) {
                            String decryptedMessage = encryptionService.decrypt(encryptedMessages.get(selectedIndex));
                            decryptedArea.setText(decryptedMessage);
                        } else {
                            decryptedArea.setText("Please select a message to decrypt.");
                        }
                    } else {
                        decryptedArea.setText("Invalid email or password.");
                    }
                } else {
                    decryptedArea.setText("Invalid email format.");
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
