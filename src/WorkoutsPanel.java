import data.DatabaseConnection;
import data.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkoutsPanel extends JPanel{
    private JLabel labelTitle;
    private JButton buttonDisconnect;
    private JList listWorkouts;
    private JButton buttonSearch;
    private JTextField textFieldSearch;
    private JLabel labelSearch;
    private JButton buttonPlus;
    private JTextField textFieldAdd;
    private JLabel labelAdd;
    private JButton buttonAdd;

    private Statement statement;

    public WorkoutsPanel(int userId) throws SQLException {
        statement = DatabaseConnection.connection.createStatement();
        //construct preComponents

        //construct components
        labelTitle = new JLabel ("GymCoach");
        buttonDisconnect = new JButton ("Deconectare");
        buttonDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeCurrentPanel(new FirstPagePanel());
            }
        });
        listWorkouts = new JList(Workout.GetWorkoutsByUserId(userId));
        listWorkouts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();

                int index = list.locationToIndex(e.getPoint()); // al catelea element din lista e
                System.out.println(index);
                Main.changeCurrentPanel(new ExercisesPanel());
            }
        });
        buttonSearch = new JButton ("Cauta");
        textFieldSearch = new JTextField (5);
        labelSearch = new JLabel ("Cauta un antrenament");
        buttonPlus = new JButton ("+");
        textFieldAdd = new JTextField (5);
        textFieldAdd.setVisible(false);
        labelAdd = new JLabel ("Adauga un antrenament");
        labelAdd.setVisible(false);
        buttonAdd = new JButton ("Adauga");
        buttonAdd.setVisible(false);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlus.setVisible(false);
                textFieldAdd.setVisible(true);
                buttonAdd.setVisible(true);
                labelAdd.setVisible(true);
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlus.setVisible(true);
                textFieldAdd.setVisible(false);
                buttonAdd.setVisible(false);
                labelAdd.setVisible(false);
            }
        });

        //adjust size and set layout
        setPreferredSize (new Dimension(944, 574));
        setLayout (null);

        //add components
        add (labelTitle);
        add (buttonDisconnect);
        add (listWorkouts);
        add (buttonSearch);
        add (textFieldSearch);
        add (labelSearch);
        add (buttonPlus);
        add (textFieldAdd);
        add (labelAdd);
        add (buttonAdd);

        //set component bounds (only needed by Absolute Positioning)
        labelTitle.setBounds (430, 55, 100, 25);
        buttonDisconnect.setBounds (10, 10, 110, 25);
        listWorkouts.setBounds (255, 165, 425, 220);
        buttonSearch.setBounds (580, 125, 100, 25);
        textFieldSearch.setBounds (395, 125, 185, 25);
        labelSearch.setBounds (255, 120, 135, 30);
        buttonPlus.setBounds (635, 400, 45, 30);
        textFieldAdd.setBounds (400, 400, 180, 25);
        labelAdd.setBounds (255, 400, 145, 25);
        buttonAdd.setBounds (575, 400, 100, 25);
    }

    String[] getWorkouts() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM workout");

        String[] data = new String[10];
        int k = 0;
        while (resultSet.next()) {
            Workout workout = new Workout(resultSet);
            data[k++] = workout.getName().toString();
            System.out.println(workout.getWorkoutId());
        };

        return data;
    }
}
