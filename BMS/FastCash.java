

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    FastCash(String pinnumber) {
    	this.pinnumber = pinnumber;

    	// Frame settings
    	setTitle("Transactions");
    	setLayout(null);

    	// Load and scale the ATM image
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

    	// Transaction selection text
    	JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT"); 
    	text.setBounds(210 ,300 ,700 ,35); 
    	text.setForeground(Color.WHITE); 
    	text.setFont(new Font("System" ,Font.BOLD ,16)); 
    	imageLabel.add(text);

    	// Transaction buttons
    	deposit = createButton("Rs 100", imageLabel ,170 ,415 ,this); 
    	withdrawl = createButton("Rs 500", imageLabel ,355 ,415 ,this); 
    	fastcash= createButton("Rs 1000", imageLabel ,170 ,450 ,this); 
    	ministatement= createButton("Rs 2000", imageLabel ,355 ,450 ,this); 
    	pinchange= createButton("Rs 5000", imageLabel ,170 ,485 ,this); 
    	balanceenquiry= createButton("Rs 10000", imageLabel ,355 ,485 ,this); 
    	exit= createButton("BACK", imageLabel ,355 ,520 ,this); 

	    // Frame settings
	    setSize(900 ,900); 
	    setLocation(300 ,0); 
	    setUndecorated(true); 
	    setVisible(true); 
    }

	private JButton createButton(String text,JLabel parent,int x,int y ,ActionListener listener){
	    JButton button=new JButton(text); 
	    button.setBounds(x,y ,150 ,30); 
	    button.addActionListener(listener); 
	    parent.add(button); 
	    return button; 
    }

    public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == exit){
	        setVisible(false);
            new Transactions(pinnumber).setVisible(true);
	    }
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
		    Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
		// else if (ae.getSource() == withdrawl) {
		// 	setVisible(false);
		// 	new Withdrawl(pinnumber).setVisible(true);
		// }	

	    // Add additional actions for other buttons as needed.
    }

    public static void main(String args[]) {
	    new FastCash(""); // This main method is just for testing; it won't be used in production.
    }
}
