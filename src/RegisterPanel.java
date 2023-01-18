import data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterPanel extends JPanel {
    private JButton buttonRegister;
    private JLabel labelTitle;
    private JLabel labelPageTitle;
    private JTextField textFieldUsername;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField textFieldPassword;
    private JButton buttonBack;

    public RegisterPanel() {
        //construct components
        buttonRegister = new JButton ("Creare cont nou");
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean created = User.CreateUser(new User(textFieldUsername.getText(), textFieldPassword.getText(), true));
                    if (created)
                        Main.changeCurrentPanel(new WorkoutsPanel(User.GetByUsername(textFieldUsername.getText()).getUser_id()));
                    else JOptionPane.showMessageDialog(null, "Numele de utlizator exista deja!");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        labelTitle = new JLabel ("GymCoach");
        labelPageTitle = new JLabel ("Creare cont nou");
        textFieldUsername = new JTextField (5);
        labelUsername = new JLabel ("Nume de utilizator:");
        labelPassword = new JLabel ("Parola:");
        textFieldPassword = new JTextField (5);
        buttonBack = new JButton ("Inapoi");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeCurrentPanel(new FirstPagePanel());
            }
        });

        //adjust size and set layout
        setPreferredSize (new Dimension(944, 574));
        setLayout (null);

        //add components
        add (buttonRegister);
        add (labelTitle);
        add (labelPageTitle);
        add (textFieldUsername);
        add (labelUsername);
        add (labelPassword);
        add (textFieldPassword);
        add (buttonBack);

        //set component bounds (only needed by Absolute Positioning)
        buttonRegister.setBounds (330, 320, 260, 40);
        labelTitle.setBounds (430, 55, 100, 25);
        labelPageTitle.setBounds (415, 80, 185, 45);
        textFieldUsername.setBounds (415, 185, 210, 25);
        labelUsername.setBounds (285, 185, 115, 25);
        labelPassword.setBounds (285, 230, 100, 25);
        textFieldPassword.setBounds (415, 230, 210, 25);
        buttonBack.setBounds (10, 10, 100, 25);
    }
}
