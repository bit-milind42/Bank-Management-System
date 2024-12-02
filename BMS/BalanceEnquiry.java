import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber= pinnumber;
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

        back = new JButton("Back");
        back.setBounds(355,520, 150,30);
        back.addActionListener(this);
        imageLabel.add(back);

        Conn c = new Conn();
        int balance =0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e)    {
            System.out.println(c);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        imageLabel.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

        
      
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String args[]){
        new BalanceEnquiry("");
    }    
}
