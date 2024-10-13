import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.*;
import java.io.*; 

public class Window extends JFrame {

	Toolkit tk = Toolkit.getDefaultToolkit();

	Window() {
		setTitle("Email Encryption");
 		setSize(tk.getScreenSize().width, tk.getScreenSize().height);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Email Label and Text Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 75, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(110, 75, 200, 30);
        
        // Password Label and Text Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 105, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 105, 200, 30);
        
        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 135, 300, 30);

        // Output Area
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 180, 300, 70);
        outputArea.setEditable(false);

        add(emailLabel);
		add(emailField);
        add(passwordLabel);
		add(passwordField);
		add(submitButton);

        JTextField senderField = new JTextField("Send to: ");
        senderField.setBounds(320, 75, 500, 30);
        JTextField subjectField = new JTextField("Subject: ");
        subjectField.setBounds(320, 105, 500, 30);
        JTextField bodyField = new JTextField("Body: ");
        bodyField.setBounds(320, 135, 500, 500);

        JButton sendButton = new JButton("Send Email");
        sendButton.setBounds(320, 635, 500, 30);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Process p = new ProcessBuilder("python3", "sendEmail.py", senderField.getText(), subjectField.getText(), bodyField.getText()).start();
                } catch(Exception ex){
        
                }
            }
        });

        add(sendButton);
        add(senderField);
		add(subjectField);
        add(bodyField);

        setVisible(true);
	}



    public static void main(String[] args) {
		Window frame = new Window();
        
        
    }

    // Email validation method using regex
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}

