package bank.management.system;

import javax.swing.*;

public class HindiLogin extends JFrame {

    HindiLogin() {

        setTitle("हिंदी लॉगिन");

        JLabel l1 = new JLabel("कार्ड नंबर");
        l1.setBounds(100,100,150,30);
        add(l1);

        setLayout(null);
        setSize(800,500);
        setVisible(true);
    }
}
