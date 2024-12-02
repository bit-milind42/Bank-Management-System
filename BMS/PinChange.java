import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PinChange extends JFrame  implements ActionListener{

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = null;
    	try {
    	    i1 = new ImageIcon(ImageIO.read(new File("C:/Users/milin/OneDrive/Desktop/Bank Mangement System/src/icons/atm.jpg")));
    	} catch (IOException e) {
    	    System.err.println("Error loading ATM image: " + e.getMessage());
    	    i1 = new ImageIcon("C:/path/to/default/image.jpg"); // Fallback path
    	}

    	Image i2 = i1.getImage().getScaledInstance(900 ,900 ,Image.SCALE_DEFAULT); 
    	ImageIcon i3 = new ImageIcon(i2); 
    	JLabel imageLabel = new JLabel(i3); 
    	imageLabel.setBounds(0 ,0 ,900 ,900); 
    	add(imageLabel);

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        // image.setBounds(0,0,900,900);
        // add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280,500,35);
        imageLabel.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320,180,25);
        imageLabel.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320,180,25);
        imageLabel.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 370,230,25);
        imageLabel.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 370,180,25);
        imageLabel.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        imageLabel.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        imageLabel.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null , "Please Enter New PIN");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null , "Please Re-enter PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='" +pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='" +pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='" +pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null , "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
