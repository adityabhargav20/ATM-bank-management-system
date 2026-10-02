package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;

    JButton b1,b2,b3,b4,b5,b6,b7;

    FastCash(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(430,180,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        b1 = new JButton("Rs. 100");
        b2 = new JButton("Rs. 500");
        b3 = new JButton("Rs. 1000");
        b4 = new JButton("Rs. 2000");
        b5 = new JButton("Rs. 5000");
        b6 = new JButton("Rs. 10000");
        b7 = new JButton("BACK");

        b1.setBounds(410,274,150,35);
        b2.setBounds(700,274,150,35);
        b3.setBounds(410,318,150,35);
        b4.setBounds(700,318,150,35);
        b5.setBounds(410,362,150,35);
        b6.setBounds(700,362,150,35);
        b7.setBounds(700,406,150,35);

        JButton[] buttons = {b1,b2,b3,b4,b5,b6,b7};

        for(JButton b : buttons){
            b.setBackground(new Color(65,125,128));
            b.setForeground(Color.WHITE);
            b.addActionListener(this);
            image.add(b);
        }

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b7){
            setVisible(false);
            new main_class(pin);
            return;
        }

        String amount = ((JButton)e.getSource()).getText().replace("Rs. ","");

        try{

            Con c = new Con();

            ResultSet rs = c.s.executeQuery(
                    "select * from bank where pin='"+pin+"'"
            );

            int balance = 0;

            while(rs.next()){

                if(rs.getString("type").equalsIgnoreCase("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if(balance < Integer.parseInt(amount)){

                JOptionPane.showMessageDialog(
                        null,
                        "Insufficient Balance"
                );
                return;
            }

            Date date = new Date();

            String query =
                    "insert into bank values('"+
                            pin+"','"+
                            date+"','Withdrawl','"+
                            amount+"')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(
                    null,
                    "Rs. "+amount+" Withdrawn Successfully"
            );

            setVisible(false);
            new main_class(pin);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
