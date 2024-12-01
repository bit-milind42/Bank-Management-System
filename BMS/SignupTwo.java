import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField aadhar, nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincTextField, pan;
    JButton next;
    JRadioButton male, female, other, ma, un,ema,eun;
    // JComboBox religion, category, occupation, education;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        getContentPane().setBackground(Color.WHITE);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(140, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String vaiReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "others"};
        JComboBox religion = new JComboBox(vaiReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);



        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
         
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        JComboBox category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10"};
        JComboBox income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationalValues[] = {"Non-Graducation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        JComboBox education = new JComboBox(educationalValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel mar = new JLabel("Occupation:");
        mar.setFont(new Font("Raleway", Font.BOLD, 22));
        mar.setBounds(100, 390, 200, 30);
        add(mar);

        String occupationalValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        JComboBox occupational = new JComboBox(occupationalValues);
        occupational.setBounds(300, 390, 400, 30);
        occupational.setBackground(Color.WHITE);
        add(occupational);


        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 16));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        ma = new JRadioButton("Yes");
        ma.setBounds(300, 540, 100, 30);
        ma.setBackground(Color.WHITE);
        add(ma);

        un = new JRadioButton("No");
        un.setBounds(450, 540, 100, 30);
        un.setBackground(Color.WHITE);
        add(un);

        ButtonGroup status = new ButtonGroup();
        status.add(ma);
        status.add(un);
        

        JLabel pinc = new JLabel("Exisiting Account:");
        pinc.setFont(new Font("Raleway", Font.BOLD, 22));
        pinc.setBounds(100, 590, 200, 30);
        add(pinc);

        ema = new JRadioButton("Yes");
        ema.setBounds(300, 590, 100, 30);
        ema.setBackground(Color.WHITE);
        add(ema);

        eun = new JRadioButton("No");
        eun.setBounds(450, 590, 100, 30);
        eun.setBackground(Color.WHITE);
        add(eun);

        ButtonGroup estatus = new ButtonGroup();
        estatus.add(ema);
        estatus.add(eun);
        

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = emailTextField.getText();
        String seniorcitizen = null ;
        

        if (ma.isSelected()){
            seniorcitizen = "Yes";

        }else if (un.isSelected()) {
            seniorcitizen = "No";
        }

        String exisitingaccount = null ;

        if (ema.isSelected()){
            exisitingaccount = "Yes";

        }else if (eun.isSelected()) {
            exisitingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();


        try {
            // if (name.equals("")) {
            //     JOptionPane.showMessageDialog(null, "Name is required");
            // } else {
                
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + exisitingaccount+"'')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
            
            // Signup3 object
            
            new SignupThree(formno).setVisible(true);
            setVisible(false);
            dispose();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

