package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class otp extends JFrame implements ActionListener {

    String pin, amount;

    JTextField otpField;
    JButton verify, back;

    otp(String pin, String amount){

        this.pin = pin;
        this.amount = amount;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel text = new JLabel("ENTER OTP");
        text.setBounds(470,180,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        JLabel hint = new JLabel("Demo OTP : 1234");
        hint.setBounds(470,220,300,30);
        hint.setForeground(Color.WHITE);
        image.add(hint);

        otpField = new JTextField();
        otpField.setBounds(460,260,250,30);
        image.add(otpField);

        verify = new JButton("VERIFY");
        verify.setBounds(700,362,150,35);
        verify.addActionListener(this);
        image.add(verify);

        back = new JButton("BACK");
        back.setBounds(700,406,150,35);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==verify){

            if(otpField.getText().equals("1234")){

                JOptionPane.showMessageDialog(
                        null,
                        "OTP Verified Successfully"
                );

                setVisible(false);

                // Yahan withdrawal continue karwa sakte ho

            }else{

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid OTP"
                );
            }

        }else if(e.getSource()==back){

            setVisible(false);
            new main_class(pin);
        }
    }
}
