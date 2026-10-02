package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class signup extends JFrame {

    JTextField nameField, fatherField, emailField, addressField, cityField, pinField, stateField;
    JComboBox<String> dayBox, monthBox, yearBox;
    JRadioButton male, female, married, unmarried;
    JLabel formNo;

    signup() {

        super("New Account Application Form");

        setLayout(null);
        setSize(1000, 650);
        setLocation(300, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BACKGROUND
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 1000, 650);
        background.setLayout(null);
        add(background);

        // BANK IMAGE
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankImg = bankIcon.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        JLabel bankLabel = new JLabel(new ImageIcon(bankImg));
        bankLabel.setBounds(60, 180, 160, 160);
        background.add(bankLabel);

        // FORM NO
        JLabel title = new JLabel("APPLICATION FORM NO:");
        title.setFont(new Font("Raleway", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setBounds(300, 20, 400, 40);
        background.add(title);

        formNo = new JLabel(String.valueOf((int)(Math.random()*9000)+1000));
        formNo.setFont(new Font("Raleway", Font.BOLD, 26));
        formNo.setForeground(Color.YELLOW);
        formNo.setBounds(700, 20, 200, 40);
        background.add(formNo);

        JLabel page = new JLabel("PAGE 1: PERSONAL DETAILS");
        page.setFont(new Font("Raleway", Font.BOLD, 22));
        page.setForeground(Color.WHITE);
        page.setBounds(340, 70, 400, 30);
        background.add(page);

        Font f = new Font("Arial", Font.BOLD, 16);

        // NAME
        JLabel name = new JLabel("Name:");
        name.setFont(f);
        name.setForeground(Color.WHITE);
        name.setBounds(300, 130, 150, 30);
        background.add(name);

        nameField = new JTextField();
        nameField.setBounds(450, 130, 250, 30);
        background.add(nameField);

        // FATHER
        JLabel father = new JLabel("Father Name:");
        father.setFont(f);
        father.setForeground(Color.WHITE);
        father.setBounds(300, 170, 150, 30);
        background.add(father);

        fatherField = new JTextField();
        fatherField.setBounds(450, 170, 250, 30);
        background.add(fatherField);

        // DOB
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setFont(f);
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setBounds(300, 210, 150, 30);
        background.add(dobLabel);

        String days[] = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);

        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        String years[] = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2026 - i);

        dayBox = new JComboBox<>(days);
        dayBox.setBounds(450, 210, 60, 30);

        monthBox = new JComboBox<>(months);
        monthBox.setBounds(520, 210, 80, 30);

        yearBox = new JComboBox<>(years);
        yearBox.setBounds(610, 210, 80, 30);

        background.add(dayBox);
        background.add(monthBox);
        background.add(yearBox);

        // EMAIL
        JLabel email = new JLabel("Email:");
        email.setFont(f);
        email.setForeground(Color.WHITE);
        email.setBounds(300, 250, 150, 30);
        background.add(email);

        emailField = new JTextField();
        emailField.setBounds(450, 250, 250, 30);
        background.add(emailField);

        // GENDER
        JLabel gender = new JLabel("Gender:");
        gender.setFont(f);
        gender.setForeground(Color.WHITE);
        gender.setBounds(300, 290, 150, 30);
        background.add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBounds(450, 290, 80, 30);
        female.setBounds(540, 290, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        background.add(male);
        background.add(female);

        // MARITAL
        JLabel marital = new JLabel("Marital:");
        marital.setFont(f);
        marital.setForeground(Color.WHITE);
        marital.setBounds(300, 330, 150, 30);
        background.add(marital);

        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");

        married.setBounds(450, 330, 100, 30);
        unmarried.setBounds(560, 330, 120, 30);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);

        background.add(married);
        background.add(unmarried);

        // ADDRESS
        JLabel address = new JLabel("Address:");
        address.setFont(f);
        address.setForeground(Color.WHITE);
        address.setBounds(300, 370, 150, 30);
        background.add(address);

        addressField = new JTextField();
        addressField.setBounds(450, 370, 250, 30);
        background.add(addressField);

        // CITY
        JLabel city = new JLabel("City:");
        city.setFont(f);
        city.setForeground(Color.WHITE);
        city.setBounds(300, 410, 150, 30);
        background.add(city);

        cityField = new JTextField();
        cityField.setBounds(450, 410, 200, 30);
        background.add(cityField);

        // PIN
        JLabel pin = new JLabel("Pincode:");
        pin.setFont(f);
        pin.setForeground(Color.WHITE);
        pin.setBounds(300, 450, 150, 30);
        background.add(pin);

        pinField = new JTextField();
        pinField.setBounds(450, 450, 200, 30);
        background.add(pinField);

        // STATE
        JLabel state = new JLabel("State:");
        state.setFont(f);
        state.setForeground(Color.WHITE);
        state.setBounds(300, 490, 150, 30);
        background.add(state);

        stateField = new JTextField();
        stateField.setBounds(450, 490, 200, 30);
        background.add(stateField);

        // NEXT BUTTON + DATABASE + NEXT PAGE
        JButton next = new JButton("NEXT");
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(760, 540, 180, 40);
        setUndecorated(true);

        next.addActionListener(e -> {

            try {

                Con c = new Con();

                String dob = dayBox.getSelectedItem() + "-" +
                        monthBox.getSelectedItem() + "-" +
                        yearBox.getSelectedItem();

                String genderValue = male.isSelected() ? "Male" : "Female";
                String maritalValue = married.isSelected() ? "Married" : "Unmarried";

                String query = "INSERT INTO signup VALUES('"
                        + formNo.getText() + "','"
                        + nameField.getText() + "','"
                        + fatherField.getText() + "','"
                        + dob + "','"
                        + emailField.getText() + "','"
                        + genderValue + "','"
                        + maritalValue + "','"
                        + addressField.getText() + "','"
                        + cityField.getText() + "','"
                        + pinField.getText() + "','"
                        + stateField.getText() + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data Saved Successfully");

                setVisible(false);

                new signup2(formNo.getText());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        background.add(next);

        setVisible(true);
    }

    public static void main(String[] args) {
        new signup();
    }
}