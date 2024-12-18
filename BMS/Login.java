import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("ATM");
        setLayout(null);

        // Load and display the logo
        ImageIcon i1 = null;
        try {
            i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
            if (i1.getImageLoadStatus() != MediaTracker.COMPLETE) {
                throw new Exception("Image not loaded");
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            // Use a placeholder path for testing
            i1 = new ImageIcon("C:/Users/milin/OneDrive/Desktop/Bank Mangement System/src/icons/logo.jpg");
            
        }
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        // Card Number field
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        // PIN field
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Buttons
        login = new JButton("Login");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Signup");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Set background color
        getContentPane().setBackground(Color.WHITE);

        // Frame settings
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            // JOptionPane.showMessageDialog(this, "Login functionality is not yet implemented.");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}

// Dummy Signup class for testing
class Signup extends JFrame {
    Signup() {
        setTitle("Signup Page");
        setSize(400, 300);
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}





