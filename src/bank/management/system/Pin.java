package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    String pin;

    JPasswordField currentPinField, newPinField, rePinField;
    JButton changeBtn, backBtn;

    Pin(String pin) {

        this.pin = pin;

        // ATM IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        // HEADING
        JLabel heading = new JLabel("CHANGE YOUR PIN");
        heading.setBounds(430, 180, 300, 35);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 18));
        image.add(heading);

        // CURRENT PIN
        JLabel currentLabel = new JLabel("Current PIN:");
        currentLabel.setBounds(430, 230, 150, 30);
        currentLabel.setForeground(Color.WHITE);
        currentLabel.setFont(new Font("System", Font.BOLD, 16));
        image.add(currentLabel);

        currentPinField = new JPasswordField();
        currentPinField.setBounds(600, 230, 180, 25);
        image.add(currentPinField);

        // NEW PIN
        JLabel newLabel = new JLabel("New PIN:");
        newLabel.setBounds(430, 280, 150, 30);
        newLabel.setForeground(Color.WHITE);
        newLabel.setFont(new Font("System", Font.BOLD, 16));
        image.add(newLabel);

        newPinField = new JPasswordField();
        newPinField.setBounds(600, 280, 180, 25);
        image.add(newPinField);

        // RE-ENTER PIN
        JLabel reLabel = new JLabel("Re-Enter PIN:");
        reLabel.setBounds(430, 330, 150, 30);
        reLabel.setForeground(Color.WHITE);
        reLabel.setFont(new Font("System", Font.BOLD, 16));
        image.add(reLabel);

        rePinField = new JPasswordField();
        rePinField.setBounds(600, 330, 180, 25);
        image.add(rePinField);

        // CHANGE BUTTON
        changeBtn = new JButton("CHANGE");
        changeBtn.setBounds(700, 380, 150, 35);
        changeBtn.setBackground(new Color(65, 125, 128));
        changeBtn.setForeground(Color.WHITE);
        changeBtn.addActionListener(this);
        image.add(changeBtn);

        // BACK BUTTON
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 425, 150, 35);
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

        if (e.getSource() == changeBtn) {

            try {

                String currentPin = String.valueOf(currentPinField.getPassword());
                String newPin = String.valueOf(newPinField.getPassword());
                String rePin = String.valueOf(rePinField.getPassword());

                if (currentPin.equals("") || newPin.equals("") || rePin.equals("")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please Fill All Fields"
                    );
                    return;
                }

                if (!currentPin.equals(pin)) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Current PIN Is Incorrect"
                    );
                    return;
                }

                if (!newPin.equals(rePin)) {

                    JOptionPane.showMessageDialog(
                            null,
                            "New PIN Does Not Match"
                    );
                    return;
                }

                Con c = new Con();

                String q1 =
                        "update login set pin='" +
                                newPin +
                                "' where pin='" +
                                pin + "'";

                String q2 =
                        "update signup3 set pin='" +
                                newPin +
                                "' where pin='" +
                                pin + "'";

                String q3 =
                        "update bank set pin='" +
                                newPin +
                                "' where pin='" +
                                pin + "'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(
                        null,
                        "PIN Changed Successfully"
                );

                setVisible(false);
                new main_class(newPin);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == backBtn) {

            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}