import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.*;
import javax.crypto.AEADBadTagException;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField,addressTextField, cityTextField,stateTextField, pincTextField;
    JButton next;
    JRadioButton male, female, other, ma, un;
    JDateChooser dateChooser;

    SignupOne(){
       
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L)+ 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds( 140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details ");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(140, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField); 


        JLabel fname = new JLabel("Father's name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField); 

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField); 

        JLabel mar = new JLabel("Marital Status:");
        mar.setFont(new Font("Raleway", Font.BOLD, 22));
        mar.setBounds(100, 390, 200, 30);
        add(mar);

        ma = new JRadioButton("Married");
        ma.setBounds(300, 390, 100, 30);
        ma.setBackground(Color.WHITE);
        add(ma);

        un = new JRadioButton("Unmarried");
        un.setBounds(450, 390, 100, 30);
        un.setBackground(Color.WHITE);
        add(un);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup status = new ButtonGroup();
        status.add(ma);
        status.add(un);
        status.add(other);

        JLabel add = new JLabel("Address:");
        add.setFont(new Font("Raleway", Font.BOLD, 22));
        add.setBounds(100, 440, 200, 30);
        add(add);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField); 

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",  Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField); 

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField); 

        JLabel pinc = new JLabel("Pincode:");
        pinc.setFont(new Font("Raleway", Font.BOLD, 22));
        pinc.setBounds(100, 590, 200, 30);
        add(pinc);

        pincTextField = new JTextField();
        pincTextField.setFont(new Font("Raleway",  Font.BOLD, 20));
        pincTextField.setBounds(300, 590, 400, 30);
        add(pincTextField); 
   
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));  
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        // if (ae.getSource()==clear) {
        //     cardTextField.setText("");
        //     pincTextField.setText("");
        // } else if (ae.getSource() == login){

        // }else if (ae.getSource() == signup){}

        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (ma.isSelected()){
            marital ="Married";
        }else if(un.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query = "Insert into signup values{'"+formno+"' , '"+name+"' ,'"+fname+"' ,'"+dob+"', '"+gender+"' ,'"+email+"', '"+marital+"','"+address+"' ,'"+city+"' ,'"+state+"', '"+pin+"')"   ;
                c.s.executeUpdate(query);
            } 
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    

 
    public static void main(String args[]) {
        new SignupOne();
    }
    
}

