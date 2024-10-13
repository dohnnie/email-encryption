import service.EncryptionService;
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



// import javax.swing.JFrame;
// import java.awt.Toolkit;
// import javax.swing.JButton;
// import javax.swing.JTextField;
// import javax.swing.JPanel;
// import java.awt.GridLayout;
// import java.awt.BorderLayout;

// public class Window extends JFrame{

// 	Toolkit tk = Toolkit.getDefaultToolkit();
	
// 	Window() {
// 		super();
// 		setTitle("Email Encryption");
// 		setSize(tk.getScreenSize().width, tk.getScreenSize().height);
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// 		JPanel screenWrapper = new JPanel(new BorderLayout());
// 		JPanel toolbar = new JPanel();
// 		JPanel mainContent = new JPanel(new BorderLayout());
// 		JPanel sidebar = new JPanel(new GridLayout(5, 1));
// 		JPanel inboxContent = new JPanel(new GridLayout(5, 1));

// 		add(screenWrapper);
// 		screenWrapper.add(toolbar, BorderLayout.NORTH);
// 		screenWrapper.add(mainContent, BorderLayout.CENTER);
// 		mainContent.add(sidebar, BorderLayout.WEST);
// 		mainContent.add(inboxContent, BorderLayout.CENTER);

// 		JButton button = new JButton("Enter");
//         button.setBounds(150, 200, 0, 0);
// 		sidebar.add(button); 	

// 		JTextField t1,t2;  
// 		t1=new JTextField("Enter Email");  
// 		t1.setBounds(50,100, 0,60);  
// 		t2=new JTextField("Enter Password");  
// 		t2.setBounds(50,150, 0,30);  
// 		inboxContent.add(t1); 
// 		inboxContent.add(t2); 

// 		setVisible(true);
// 	}

// 	public static void main(String[] args) {
// 		new Window();
// 	}
// }





/*

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
*/