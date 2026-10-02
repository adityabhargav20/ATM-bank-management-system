package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class signup3 extends JFrame {

    String formno;

    JRadioButton saving, current, fixed, recurring;
    JCheckBox atm, internet, mobile, email, cheque, eStatement;

    JLabel cardLabel, pinLabel;

    signup3(String formno) {

        this.formno = formno;

        setTitle("Signup Page 3");
        setSize(900, 650);
        setLocation(300, 100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BACKGROUND
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 900, 650);
        background.setLayout(null);
        add(background);

        // TITLE
        JLabel title = new JLabel("PAGE 3: ACCOUNT DETAILS");
        title.setFont(new Font("Raleway", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setBounds(250, 30, 500, 40);
        background.add(title);

        Font f = new Font("Arial", Font.BOLD, 15);

        // ACCOUNT TYPE
        JLabel type = new JLabel("Account Type:");
        type.setFont(f);
        type.setForeground(Color.WHITE);
        type.setBounds(200, 100, 200, 30);
        background.add(type);

        saving = new JRadioButton("Saving Account");
        current = new JRadioButton("Current Account");
        fixed = new JRadioButton("Fixed Deposit");
        recurring = new JRadioButton("Recurring Deposit");

        saving.setBounds(200, 140, 150, 30);
        current.setBounds(380, 140, 150, 30);
        fixed.setBounds(200, 170, 150, 30);
        recurring.setBounds(380, 170, 170, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(saving);
        bg.add(current);
        bg.add(fixed);
        bg.add(recurring);

        background.add(saving);
        background.add(current);
        background.add(fixed);
        background.add(recurring);

        // CARD NUMBER
        Random r = new Random();
        String cardNo = "" + Math.abs(r.nextLong() % 9000000000000000L + 1000000000000000L);

        JLabel cardText = new JLabel("Card Number:");
        cardText.setFont(f);
        cardText.setForeground(Color.WHITE);
        cardText.setBounds(200, 230, 150, 30);
        background.add(cardText);

        cardLabel = new JLabel(cardNo);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 18));
        cardLabel.setForeground(Color.YELLOW);
        cardLabel.setBounds(380, 230, 400, 30);
        background.add(cardLabel);

        // PIN
        String pinNo = "" + (1000 + new Random().nextInt(9000));

        JLabel pinText = new JLabel("PIN:");
        pinText.setFont(f);
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(200, 280, 150, 30);
        background.add(pinText);

        pinLabel = new JLabel(pinNo);
        pinLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pinLabel.setForeground(Color.YELLOW);
        pinLabel.setBounds(380, 280, 200, 30);
        background.add(pinLabel);

        // SERVICES
        JLabel service = new JLabel("Services Required:");
        service.setFont(f);
        service.setForeground(Color.WHITE);
        service.setBounds(200, 330, 200, 30);
        background.add(service);

        atm = new JCheckBox("ATM Card");
        internet = new JCheckBox("Internet Banking");
        mobile = new JCheckBox("Mobile Banking");
        email = new JCheckBox("Email Alerts");
        cheque = new JCheckBox("Cheque Book");
        eStatement = new JCheckBox("E-Statement");

        atm.setBounds(200, 370, 150, 30);
        internet.setBounds(380, 370, 200, 30);
        mobile.setBounds(200, 400, 200, 30);
        email.setBounds(380, 400, 200, 30);
        cheque.setBounds(200, 430, 200, 30);
        eStatement.setBounds(380, 430, 200, 30);

        background.add(atm);
        background.add(internet);
        background.add(mobile);
        background.add(email);
        background.add(cheque);
        background.add(eStatement);

        // SUBMIT BUTTON
        JButton submit = new JButton("SUBMIT");
        submit.setBounds(550, 500, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
setUndecorated(true);
        submit.addActionListener(e -> {

            try {
                Con c = new Con();

                // ACCOUNT TYPE (ONLY ONCE VARIABLE)
                String accountType = "";

                if (saving.isSelected()) accountType = "Saving Account";
                else if (current.isSelected()) accountType = "Current Account";
                else if (fixed.isSelected()) accountType = "Fixed Deposit";
                else if (recurring.isSelected()) accountType = "Recurring Deposit";

                // SERVICES
                String services = "";
                if (atm.isSelected()) services += "ATM Card ";
                if (internet.isSelected()) services += "Internet Banking ";
                if (mobile.isSelected()) services += "Mobile Banking ";
                if (email.isSelected()) services += "Email Alerts ";
                if (cheque.isSelected()) services += "Cheque Book ";
                if (eStatement.isSelected()) services += "E-Statement ";

                String query = "INSERT INTO signup3 VALUES('" +
                        formno + "','" +
                        accountType + "','" +
                        cardLabel.getText() + "','" +
                        pinLabel.getText() + "','" +
                        services + "')";

                c.s.executeUpdate(query);
                String query2 = "insert into login values('" +
                        formno + "','" +
                        cardLabel.getText() + "','" +
                        pinLabel.getText() + "')";
                System.out.println("Saving in login table...");
                System.out.println("Form No: " + formno);
                System.out.println("Card No: " + cardLabel.getText());
                System.out.println("Pin: " + pinLabel.getText());
                System.out.println(query2);

                c.s.executeUpdate(query2);

                System.out.println("LOGIN TABLE INSERTED");

                JOptionPane.showMessageDialog(null, "Account Created Successfully!");

                setVisible(false);
                new login();



            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
            }

        });

        background.add(submit);

        // CANCEL BUTTON
        JButton cancel = new JButton("CANCEL");
        cancel.setBounds(700, 500, 120, 40);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);

        cancel.addActionListener(e -> setVisible(false));

        background.add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new signup3("");
    }
}