package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {

    String pin;
    JButton exit;

    mini(String pin) {

        this.pin = pin;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel heading = new JLabel("BANK MANAGEMENT SYSTEM");
        heading.setBounds(120,20,300,30);
        heading.setFont(new Font("System",Font.BOLD,18));
        add(heading);

        JLabel card = new JLabel();
        card.setBounds(20,80,400,20);
        add(card);

        JLabel miniStatement = new JLabel();
        miniStatement.setBounds(20,120,450,250);
        add(miniStatement);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20,400,300,20);
        balanceLabel.setFont(new Font("System",Font.BOLD,14));
        add(balanceLabel);

        exit = new JButton("EXIT");
        exit.setBounds(180,470,100,30);
        exit.addActionListener(this);
        add(exit);

        try {

            Con c = new Con();

            ResultSet rs1 = c.s.executeQuery(
                    "select * from login where pin='" + pin + "'"
            );

            if(rs1.next()) {

                String cardno = rs1.getString("cardno");

                card.setText(
                        "Card Number : "
                                + cardno.substring(0,4)
                                + "XXXXXXXX"
                                + cardno.substring(12)
                );
            }

            int balance = 0;

            ResultSet rs2 = c.s.executeQuery(
                    "select * from bank where pin='" + pin + "'"
            );

            String text = "<html>";

            while(rs2.next()) {

                text += rs2.getString("date")
                        + "&nbsp;&nbsp;"
                        + rs2.getString("type")
                        + "&nbsp;&nbsp;"
                        + rs2.getString("amount")
                        + "<br><br>";

                if(rs2.getString("type").equalsIgnoreCase("Deposit")) {

                    balance += Integer.parseInt(
                            rs2.getString("amount")
                    );

                } else {

                    balance -= Integer.parseInt(
                            rs2.getString("amount")
                    );
                }
            }

            text += "</html>";

            miniStatement.setText(text);

            balanceLabel.setText(
                    "Your Total Balance Is Rs " + balance
            );

        } catch(Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(new Color(255,220,220));

        setSize(500,600);
        setLocation(400,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exit) {

            dispose();

            new main_class(pin);
        }
    }

    public static void main(String[] args) {

        new mini("8188");
    }
}