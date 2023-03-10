import data.DatabaseConnection;
import data.Workout;

import javax.swing.*;
import javax.swing.event.ListDataListener;
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
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Workout) {
                        Workout selectedWorkout = (Workout) selectedObj;
                        System.out.println(selectedWorkout.getWorkoutId());
                        try {
                            Main.changeCurrentPanel(new ExercisesPanel(selectedWorkout.getWorkoutId()));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        buttonSearch = new JButton ("Cauta");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listWorkouts.setListData(Workout.GetWorkoutsByString(userId, textFieldSearch.getText()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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

                try {
                    Workout.CreateWorkout(new Workout(textFieldAdd.getText(), 1, userId));
                    listWorkouts.setListData(Workout.GetWorkoutsByUserId(userId));
                    textFieldAdd.setText("");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
}
