import data.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.*;

public class LoginPanel extends JPanel {
    private JButton buttonLogin;
    private JLabel labelTitle;
    private JLabel labelPageTitle;
    private JTextField textFieldUsername;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField textFieldPassword;
    private JButton buttonBack;

    public LoginPanel() {
        //construct components
        buttonLogin = new JButton ("Conectare la cont");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User currentUser = User.GetByUsername(textFieldUsername.getText());
                    if (currentUser.getActive() && Objects.equals(currentUser.getPassword(), textFieldPassword.getText()))
                        Main.changeCurrentPanel(new WorkoutsPanel(currentUser.getUser_id())); // change to first page
                    else JOptionPane.showMessageDialog(null, "Username or password not correct");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        labelTitle = new JLabel ("GymCoach");
        labelPageTitle = new JLabel ("Conectare la cont existent");
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
        add (buttonLogin);
        add (labelTitle);
        add (labelPageTitle);
        add (textFieldUsername);
        add (labelUsername);
        add (labelPassword);
        add (textFieldPassword);
        add (buttonBack);

        //set component bounds (only needed by Absolute Positioning)
        buttonLogin.setBounds (330, 320, 260, 40);
        labelTitle.setBounds (430, 55, 100, 25);
        labelPageTitle.setBounds (390, 80, 185, 45);
        textFieldUsername.setBounds (415, 185, 210, 25);
        labelUsername.setBounds (285, 185, 115, 25);
        labelPassword.setBounds (285, 230, 100, 25);
        textFieldPassword.setBounds (415, 230, 210, 25);
        buttonBack.setBounds (10, 10, 100, 25);
    }
}
