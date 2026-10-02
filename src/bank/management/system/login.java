package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField cardTextField;
    JPasswordField pinTextField;

    JButton signin, clear, signup, eyeButton;

    login() {

        super("Bank Management System");

        setLayout(null);

        // Background Image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 850, 480);
        background.setLayout(null);
        add(background);

        // Bank Logo
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankImg = bankIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel bankLabel = new JLabel(new ImageIcon(bankImg));
        bankLabel.setBounds(370, 10, 100, 100);
        background.add(bankLabel);

        // Card Image
        ImageIcon cardIcon = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image cardImg = cardIcon.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT);
        JLabel cardLabel = new JLabel(new ImageIcon(cardImg));
        cardLabel.setBounds(650, 350, 120, 80);
        background.add(cardLabel);

        // Heading
        JLabel heading = new JLabel("WELCOME TO ATM");
        heading.setFont(new Font("Raleway", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        heading.setBounds(260, 120, 350, 40);
        background.add(heading);

        // Card Number
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setForeground(Color.WHITE);
        cardNo.setBounds(150, 190, 150, 30);
        background.add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(320, 190, 250, 30);
        background.add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setForeground(Color.WHITE);
        pin.setBounds(150, 250, 150, 30);
        background.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setEchoChar('*');
        pinTextField.setBounds(320, 250, 250, 30);
        background.add(pinTextField);

        // Eye Button
        eyeButton = new JButton("👁");
        eyeButton.setBounds(580, 250, 50, 30);

        eyeButton.addActionListener(e -> {
            if (pinTextField.getEchoChar() == '*') {
                pinTextField.setEchoChar((char) 0);
            } else {
                pinTextField.setEchoChar('*');
            }
        });

        background.add(eyeButton);

        // SIGN IN
        signin = new JButton("SIGN IN");
        signin.setBounds(220, 320, 120, 35);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        background.add(signin);

        // CLEAR
        clear = new JButton("CLEAR");
        clear.setBounds(370, 320, 120, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        background.add(clear);

        // SIGN UP
        signup = new JButton("SIGN UP");
        signup.setBounds(295, 380, 120, 35);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        background.add(signup);

        setSize(850, 480);
        setLocation(350, 180);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signin) {

            try {

                Con c = new Con();

                String cardno = cardTextField.getText();
                String pin = String.valueOf(pinTextField.getPassword());

                String q = "select * from login where cardno='" +
                        cardno + "' and pin='" +
                        pin + "'";

                ResultSet resultSet = c.s.executeQuery(q);

                if (resultSet.next()) {

                    System.out.println("LOGIN SUCCESS");

                    JOptionPane.showMessageDialog(
                            null,
                            "Login Successful"
                    );

                    setVisible(false);

                    new main_class(pin);

                } else {

                    System.out.println("LOGIN FAILED");

                    JOptionPane.showMessageDialog(
                            null,
                            "Incorrect Card Number or PIN"
                    );
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == clear) {

            cardTextField.setText("");
            pinTextField.setText("");

        } else if (e.getSource() == signup) {

            setVisible(false);

            new signup();
        }
    }




    public static void main(String[] args) {
        new login();
    }
}