import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FirstPagePanel extends JPanel {
    private JButton buttonLogin;
    private JButton buttonRegister;
    private JLabel labelTitle;

    public FirstPagePanel() {
        //construct components
        buttonLogin = new JButton ("Conectare la cont");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeCurrentPanel(new LoginPanel());
            }
        });
        buttonRegister = new JButton ("Creare cont nou");
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeCurrentPanel(new RegisterPanel());
            }
        });
        labelTitle = new JLabel ("GymCoach");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //add components
        add (buttonLogin);
        add (buttonRegister);
        add (labelTitle);

        //set component bounds (only needed by Absolute Positioning)
        buttonLogin.setBounds (330, 190, 260, 40);
        buttonRegister.setBounds (330, 255, 260, 40);
        labelTitle.setBounds (430, 55, 100, 25);
    }
}
