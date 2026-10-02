package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton withdrawBtn, backBtn;

    withdrawl(String pin) {

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setBounds(460, 180, 400, 35);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        image.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setBounds(460, 220, 400, 35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        image.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 260, 320, 30);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(textField);

        withdrawBtn = new JButton("WITHDRAW");
        withdrawBtn.setBounds(700, 362, 150, 35);
        withdrawBtn.setBackground(new Color(65, 125, 128));
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        backBtn.setBackground(new Color(65, 125, 128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        image.add(backBtn);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == withdrawBtn) {

                String amount = textField.getText();
                Date date = new Date();

                if (amount.equals("")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter the amount you want to withdraw"
                    );

                    return;
                }

                if (Integer.parseInt(amount) > 10000) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Maximum Withdrawal Limit is Rs.10,000"
                    );

                    return;
                }

                Con c = new Con();

                ResultSet rs = c.s.executeQuery(
                        "select * from bank where pin='" + pin + "'"
                );

                int balance = 0;

                while (rs.next()) {

                    String type = rs.getString("type");
                    int amt = Integer.parseInt(rs.getString("amount"));

                    if (type.equalsIgnoreCase("Deposit")) {

                        balance += amt;

                    } else {

                        balance -= amt;
                    }
                }

                if (balance < Integer.parseInt(amount)) {

                    JOptionPane.showMessageDialog(
                            null, "Insufficient Balance"
                    );

                    return;
                }
                int withdrawAmount = Integer.parseInt(amount);

                if(withdrawAmount > 10000){

                    String otp = JOptionPane.showInputDialog(
                            null,
                            "Enter OTP (Demo OTP : 1234)"
                    );

                    if(otp == null || !otp.equals("1234")){

                        JOptionPane.showMessageDialog(
                                null,
                                "Invalid OTP"
                        );

                        return;
                    }
                }

                String query =
                        "insert into bank values('" +
                                pin + "','" +
                                date + "','Withdrawl','" +
                                amount + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Rs. " + amount + " Debited Successfully"
                );

                setVisible(false);

                new main_class(pin);

            } else if (e.getSource() == backBtn) {

                setVisible(false);

                new main_class(pin);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new withdrawl("");
    }
}
