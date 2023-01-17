import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Main.changeCurrentPanel(new WorkoutsPanel());
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
