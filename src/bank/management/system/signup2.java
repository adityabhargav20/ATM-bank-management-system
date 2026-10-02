package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class signup2 extends JFrame {

    String formno;

    JComboBox<String> religionBox, categoryBox, incomeBox, occupationBox;
    JTextField panField, aadharField;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;

    // 🔥 CONSTRUCTOR (IMPORTANT PART)
    public signup2(String formno) {

        this.formno = formno;

        setTitle("Signup Page 2");
        setSize(1000, 650);
        setLocation(300, 80);
        setLayout(null);

        // BACKGROUND
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 1000, 650);
        background.setLayout(null);
        add(background);

        // TITLE
        JLabel title = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        title.setFont(new Font("Raleway", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setBounds(300, 40, 500, 40);
        background.add(title);

        Font f = new Font("Arial", Font.BOLD, 14);

        // RELIGION
        religionBox = new JComboBox<>(new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Other"});
        religionBox.setBounds(400, 120, 200, 30);
        background.add(religionBox);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(200, 120, 150, 30);
        religion.setFont(f);
        religion.setForeground(Color.WHITE);
        background.add(religion);

        // CATEGORY
        categoryBox = new JComboBox<>(new String[]{"General", "OBC", "SC", "ST", "Other"});
        categoryBox.setBounds(400, 160, 200, 30);
        background.add(categoryBox);

        JLabel category = new JLabel("Category:");
        category.setBounds(200, 160, 150, 30);
        category.setFont(f);
        category.setForeground(Color.WHITE);
        background.add(category);

        // INCOME
        incomeBox = new JComboBox<>(new String[]{"Null", "<1.5 Lakh", "1.5L-5L", "5L+"});
        incomeBox.setBounds(400, 200, 200, 30);
        background.add(incomeBox);

        JLabel income = new JLabel("Income:");
        income.setBounds(200, 200, 150, 30);
        income.setFont(f);
        income.setForeground(Color.WHITE);
        background.add(income);

        // OCCUPATION
        occupationBox = new JComboBox<>(new String[]{"Salaried", "Self-Employed", "Business", "Student", "Retired"});
        occupationBox.setBounds(400, 240, 200, 30);
        background.add(occupationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(200, 240, 150, 30);
        occupation.setFont(f);
        occupation.setForeground(Color.WHITE);
        background.add(occupation);

        // PAN
        panField = new JTextField();
        panField.setBounds(400, 280, 200, 30);
        background.add(panField);

        JLabel pan = new JLabel("PAN No:");
        pan.setBounds(200, 280, 150, 30);
        pan.setFont(f);
        pan.setForeground(Color.WHITE);
        background.add(pan);

        // AADHAR
        aadharField = new JTextField();
        aadharField.setBounds(400, 320, 200, 30);
        background.add(aadharField);

        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setBounds(200, 320, 150, 30);
        aadhar.setFont(f);
        aadhar.setForeground(Color.WHITE);
        background.add(aadhar);

        // SENIOR
        seniorYes = new JRadioButton("Yes");
        seniorNo = new JRadioButton("No");

        seniorYes.setBounds(400, 360, 60, 30);
        seniorNo.setBounds(480, 360, 60, 30);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(seniorYes);
        bg1.add(seniorNo);

        background.add(seniorYes);
        background.add(seniorNo);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setBounds(200, 360, 150, 30);
        senior.setFont(f);
        senior.setForeground(Color.WHITE);
        background.add(senior);

        // EXISTING
        existingYes = new JRadioButton("Yes");
        existingNo = new JRadioButton("No");

        existingYes.setBounds(400, 400, 60, 30);
        existingNo.setBounds(480, 400, 60, 30);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(existingYes);
        bg2.add(existingNo);

        background.add(existingYes);
        background.add(existingNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setBounds(200, 400, 150, 30);
        existing.setFont(f);
        existing.setForeground(Color.WHITE);
        background.add(existing);

        // NEXT BUTTON
        JButton next = new JButton("NEXT");
        next.setBounds(650, 500, 120, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        setUndecorated(true);

        // 🔥 DATABASE + NEXT FLOW
        next.addActionListener(e -> {

            try {

                Con c = new Con();

                String query = "INSERT INTO signup2 VALUES('" +
                        formno + "','" +
                        religionBox.getSelectedItem() + "','" +
                        categoryBox.getSelectedItem() + "','" +
                        incomeBox.getSelectedItem() + "','" +
                        occupationBox.getSelectedItem() + "','" +
                        panField.getText() + "','" +
                        aadharField.getText() + "','" +
                        (seniorYes.isSelected() ? "Yes" : "No") + "','" +
                        (existingYes.isSelected() ? "Yes" : "No") + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Page 2 Saved");

                setVisible(false);

                // 🔥 NEXT PAGE OPEN
                new signup3(formno);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        background.add(next);

        setVisible(true);
    }

    // 🔥 MAIN METHOD (TESTING ONLY)
    public static void main(String[] args) {
        new signup2("1234");
    }
}