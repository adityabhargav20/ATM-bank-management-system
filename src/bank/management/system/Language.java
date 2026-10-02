package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Language extends JFrame {

    Language() {

        // ATM IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 830);
        add(image);

        // HEADING
        JLabel label = new JLabel("PLEASE SELECT YOUR LANGUAGE");
        label.setBounds(420, 180, 400, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 18));
        image.add(label);

        // ENGLISH BUTTON
        JButton english = new JButton("ENGLISH");
        english.setBounds(410, 274, 150, 35);
        english.setBackground(new Color(65,125,128));
        english.setForeground(Color.WHITE);
        image.add(english);

        // HINDI BUTTON
        JButton hindi = new JButton("HINDI");
        hindi.setBounds(700, 274, 150, 35);
        hindi.setBackground(new Color(65,125,128));
        hindi.setForeground(Color.WHITE);
        image.add(hindi);

        // ENGLISH
        english.addActionListener(e -> {
            setVisible(false);
            new login();
        });

        // HINDI
        hindi.addActionListener(e -> {
            setVisible(false);
            new login();
        });

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Language();
    }
}