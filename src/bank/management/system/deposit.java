package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton depositBtn, backBtn;

    deposit(String pin) {

        this.pin = pin;

        setLayout(null);

        // ATM IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        // HEADING
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setBounds(460, 180, 400, 35);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        image.add(label1);

        // TEXT FIELD
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 230, 320, 30);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(textField);

        // DEPOSIT BUTTON
        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(700, 362, 150, 35);
        depositBtn.setBackground(new Color(65, 125, 128));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        // BACK BUTTON
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        backBtn.setBackground(new Color(65, 125, 128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        image.add(backBtn);

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {

            setVisible(false);
            new main_class(pin);
            return;
        }

        String amount = textField.getText();
        Date date = new Date();

        if (e.getSource() == depositBtn) {

            if (amount.equals("")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Please Enter Amount"
                );

            } else {

                try {

                    Con c = new Con();

                    String query =
                            "insert into bank values('" +
                                    pin + "','" +
                                    date + "','Deposit','" +
                                    amount + "')";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(
                            null,
                            "Rs. " + amount + " Deposited Successfully"
                    );

                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }



    public static void main(String[] args) {
        new deposit("1234");
    }
}