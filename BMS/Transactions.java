// import java.awt.Color;
// import java.awt.Font;
// import java.awt.Image;
// import java.awt.event.*;
// import javax.swing.*;

// public class Transactions extends JFrame implements ActionListener{
//     JButton deposit,withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
//     String pinnumber;
//     Transactions(String pinnumber){
//         this.pinnumber = pinnumber;
//         setLayout(null);

//         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/atm.jpg"));
//         Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//         ImageIcon i3 = new ImageIcon(i2);
//         JLabel image = new JLabel(i3);
//         image.setBounds(0, 0, 900, 900);
//         add(image);

//         JLabel text = new JLabel("Please select your Transaction");
//         text.setBounds(210,300,700,35);
//         text.setForeground(Color.WHITE);
//         text.setFont(new Font("System", Font.BOLD, 16));
//         image.add(text);

//         deposit = new JButton("Deposit");
//         deposit.setBounds(170,415,150,30);
//         deposit.addActionListener(this);
//         image.add(deposit);

//         withdrawl = new JButton("Cash Withdrawl");
//         withdrawl.setBounds(355,415,150,30);
//         withdrawl.addActionListener(this);
//         image.add(withdrawl);

//         fastcash = new JButton("Fast cash");
//         fastcash.setBounds(170,450,150,30);
//         fastcash.addActionListener(this);
//         image.add(fastcash);

//         ministatement = new JButton("Mini Statement");
//         ministatement.setBounds(355,450,150,30);
//         ministatement.addActionListener(this);
//         image.add(ministatement);

//         pinchange= new JButton("Pin Change");
//         pinchange.setBounds(170,485,150,30);
//         pinchange.addActionListener(this);
//         image.add(pinchange);

//         balanceenquiry= new JButton("Balance Enquiry");
//         balanceenquiry.setBounds(355,485,150,30);
//         balanceenquiry.addActionListener(this);
//         image.add(balanceenquiry);

//         exit= new JButton("Exit");
//         exit.setBounds(355,520,150,30);
//         exit.addActionListener(this);
//         image.add(exit);

//         setSize(900,900);
//         setLocation(300,0);
//         setUndecorated(true);
//         setVisible(true);
        

//     }

//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == exit){
//             System.exit(0);
//         }
//     }
//     public static void main(String args[]){
//         new Transactions("");
 
//     }
    
// }







import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    Transactions(String pinnumber) {
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
    	JLabel text = new JLabel("Please select your Transaction"); 
    	text.setBounds(210 ,300 ,700 ,35); 
    	text.setForeground(Color.WHITE); 
    	text.setFont(new Font("System" ,Font.BOLD ,16)); 
    	imageLabel.add(text);

    	// Transaction buttons
    	deposit = createButton("Deposit", imageLabel ,170 ,415 ,this); 
    	withdrawl = createButton("Cash Withdrawl", imageLabel ,355 ,415 ,this); 
    	fastcash= createButton("Fast Cash", imageLabel ,170 ,450 ,this); 
    	ministatement= createButton("Mini Statement", imageLabel ,355 ,450 ,this); 
    	pinchange= createButton("Pin Change", imageLabel ,170 ,485 ,this); 
    	balanceenquiry= createButton("Balance Enquiry", imageLabel ,355 ,485 ,this); 
    	exit= createButton("Exit", imageLabel ,355 ,520 ,this); 

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
	        System.exit(0); 
	    }
		else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		else if (ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}	
		else if (ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}       
        // else if (ae.getSource() == pinchange) {
		// 	setVisible(false);
		// 	new PinChange(pinnumber).setVisible(true);
		// }
        else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true); 
        }

        else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true); // Corrected redirection
        }

        else if (ae.getSource() == ministatement) {
            
            new MiniStatement(pinnumber).setVisible(true); 
        }

	    // Add additional actions for other buttons as needed.
    }

    public static void main(String args[]) {
	    new Transactions(""); // This main method is just for testing; it won't be used in production.
    }
}







// import java.awt.Color;
// import java.awt.Font;
// import java.awt.Image;
// import java.awt.event.*;
// import java.io.File;
// import java.io.IOException;
// import javax.imageio.ImageIO;
// import javax.swing.*;

// public class Transactions extends JFrame implements ActionListener {
//     JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
//     String pinnumber;

//     Transactions(String pinnumber) {
//         this.pinnumber = pinnumber;

//         // Frame settings
//         setTitle("Transactions");
//         setLayout(null);

//         // Load and scale the ATM image
//         ImageIcon i1 = null;
//         try {
//             i1 = new ImageIcon(ImageIO.read(new File("C:/Users/milin/OneDrive/Desktop/Bank Mangement System/src/icons/atm.jpg")));
//         } catch (IOException e) {
//             System.err.println("Error loading ATM image: " + e.getMessage());
//             i1 = new ImageIcon("C:/path/to/default/image.jpg"); // Fallback path
//         }

//         Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//         ImageIcon i3 = new ImageIcon(i2);
//         JLabel imageLabel = new JLabel(i3);
//         imageLabel.setBounds(0, 0, 900, 900);
//         add(imageLabel);

//         // Transaction selection text
//         JLabel text = new JLabel("Please select your Transaction");
//         text.setBounds(210, 300, 700, 35);
//         text.setForeground(Color.WHITE);
//         text.setFont(new Font("System", Font.BOLD, 16));
//         imageLabel.add(text);

//         // Transaction buttons
//         deposit = createButton("Deposit", imageLabel, 170, 415, this);
//         withdrawl = createButton("Cash Withdrawl", imageLabel, 355, 415, this);
//         fastcash = createButton("Fast Cash", imageLabel, 170, 450, this);
//         ministatement = createButton("Mini Statement", imageLabel, 355, 450, this);
//         pinchange = createButton("Pin Change", imageLabel, 170, 485, this); // Pin Change button
//         balanceenquiry = createButton("Balance Enquiry", imageLabel, 355, 485, this);
//         exit = createButton("Exit", imageLabel, 355, 520, this);

//         // Frame settings
//         setSize(900, 900);
//         setLocation(300, 0);
//         setUndecorated(true);
//         setVisible(true);
//     }

//     private JButton createButton(String text, JLabel parent, int x, int y, ActionListener listener) {
//         JButton button = new JButton(text);
//         button.setBounds(x, y, 150, 30);
//         button.addActionListener(listener);
//         parent.add(button);
//         return button;
//     }

//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == exit) {
//             System.exit(0);
//         } else if (ae.getSource() == pinchange) {
//             setVisible(false);
//             new PinChange(pinnumber).setVisible(true); // Corrected redirection
//         }
//         // Add other button actions here if needed
//     }

//     public static void main(String args[]) {
//         new Transactions("");
//     }
// }
