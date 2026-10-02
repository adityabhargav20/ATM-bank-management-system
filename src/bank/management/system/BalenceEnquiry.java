package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalenceEnquiry extends JFrame implements ActionListener {

    String pin;
    JButton backBtn;

    BalenceEnquiry(String pin) {

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        JLabel heading = new JLabel("YOUR CURRENT ACCOUNT BALANCE IS");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 16));
        heading.setBounds(430, 180, 400, 30);
        image.add(heading);

        int balance = 0;

        try {

            Con c = new Con();

            ResultSet rs = c.s.executeQuery(
                    "select * from bank where pin='" + pin + "'"
            );

            while (rs.next()) {

                if (rs.getString("type").equalsIgnoreCase("Deposit")) {

                    balance += Integer.parseInt(rs.getString("amount"));

                } else {

                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel amount = new JLabel("Rs. " + balance);
        amount.setForeground(Color.YELLOW);
        amount.setFont(new Font("System", Font.BOLD, 25));
        amount.setBounds(500, 250, 300, 35);
        image.add(amount);

        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 406, 150, 35);
        backBtn.setBackground(new Color(65,125,128));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        image.add(backBtn);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {

            setVisible(false);

            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new BalenceEnquiry("");
    }
}