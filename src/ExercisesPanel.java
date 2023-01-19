import data.Exercise;
import data.Set;
import data.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ExercisesPanel extends JPanel {
    private JLabel labelTitle;
    private JButton buttonBack;
    private JList listExercises;
    private JLabel labelWorkout;
    private JLabel labelWorkoutName;
    private JLabel labelAddExercise;
    private JTextField textFieldAddExercise;
    private JButton buttonAddExercise;
    private JLabel labelExercise;
    private JLabel labelExerciseName;
    private JList listSets;
    private JLabel labelAddSet;
    private JTextField textFieldRepetitions;
    private JLabel labelRepetitions;
    private JLabel labelWeight;
    private JTextField textFieldWeight;
    private JLabel labelMentions;
    private JTextField textFieldMentions;
    private JButton buttonAddSet;
    private JComboBox comboBoxMuscleGroup;
    private JLabel labelMuscleGroup;


    public ExercisesPanel(int workoutId) throws SQLException{
        //construct preComponents
        String[] listSetItems = {""};
        String[] comboBoxMuscleGroupItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        labelTitle = new JLabel ("GymCoach");
        buttonBack = new JButton ("Inapoi");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Workout workout = Workout.GetWorkoutForAnExercise(workoutId);
                    Main.changeCurrentPanel(new WorkoutsPanel(workout.getUserId()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        try {
            listExercises = new JList (Exercise.GetExercisesByWorkoutId(workoutId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        listSets = new JList(listSetItems);
        listExercises.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();

                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Exercise) {
                        Exercise selectedExercise = (Exercise) selectedObj;
                        System.out.println(selectedExercise.getExerciseId());
                        try {
                            listSets.setListData(Set.GetSetsByExerciseId(selectedExercise.getExerciseId()));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        labelWorkout = new JLabel ("Antrenament");
        labelWorkoutName = new JLabel ("antrenamentulMeu");
        labelAddExercise = new JLabel ("Adauga un exercitiu");
        textFieldAddExercise = new JTextField (5);
        buttonAddExercise = new JButton ("Adauga");
        buttonAddExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exercise.CreateExercise(new Exercise(workoutId, textFieldAddExercise.getText()));
                    listExercises.setListData(Exercise.GetExercisesByWorkoutId(workoutId));
                    textFieldAddExercise.setText("");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        labelExercise = new JLabel ("Exercitiu");
        labelExerciseName = new JLabel ("exercitiul meu");
        labelAddSet = new JLabel ("Adauga un set");
        textFieldRepetitions = new JTextField (5);
        labelRepetitions = new JLabel ("Numar repetari:");
        labelWeight = new JLabel ("Greutate:");
        textFieldWeight = new JTextField (5);
        labelMentions = new JLabel ("Mentiuni:");
        textFieldMentions = new JTextField (5);
        buttonAddSet = new JButton ("Adauga");
        buttonAddSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = listExercises.getSelectedValue();
                if (selectedObj instanceof Exercise) {
                    Exercise selectedExercise = (Exercise) selectedObj;
                    try {
                        Set.CreateSet(new Set(selectedExercise.getExerciseId(),
                                textFieldMentions.getText(),
                                Integer.parseInt(textFieldWeight.getText()),
                                Integer.parseInt(textFieldRepetitions.getText())));

                        // refresh
                        listSets.setListData(Set.GetSetsByExerciseId(selectedExercise.getExerciseId()));

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        comboBoxMuscleGroup = new JComboBox (comboBoxMuscleGroupItems);
        labelMuscleGroup = new JLabel ("Grupa de muschi a antrenamentului");

        //adjust size and set layout
        setPreferredSize (new Dimension(944, 574));
        setLayout (null);

        //add components
        add (labelTitle);
        add (buttonBack);
        add (listExercises);
        add (labelWorkout);
        add (labelWorkoutName);
        add (labelAddExercise);
        add (textFieldAddExercise);
        add (buttonAddExercise);
        add (labelExercise);
        add (labelExerciseName);
        add (listSets);
        add (labelAddSet);
        add (textFieldRepetitions);
        add (labelRepetitions);
        add (labelWeight);
        add (textFieldWeight);
        add (labelMentions);
        add (textFieldMentions);
        add (buttonAddSet);
        add (comboBoxMuscleGroup);
        add (labelMuscleGroup);

        //set component bounds (only needed by Absolute Positioning)
        labelTitle.setBounds (430, 55, 100, 25);
        buttonBack.setBounds (10, 10, 90, 25);
        listExercises.setBounds (60, 160, 380, 215);
        labelWorkout.setBounds (65, 120, 115, 30);
        labelWorkoutName.setBounds (190, 120, 225, 30);
        labelAddExercise.setBounds (60, 390, 125, 25);
        textFieldAddExercise.setBounds (180, 390, 165, 25);
        buttonAddExercise.setBounds (345, 390, 95, 25);
        labelExercise.setBounds (495, 125, 100, 25);
        labelExerciseName.setBounds (590, 125, 185, 25);
        listSets.setBounds (495, 160, 390, 215);
        labelAddSet.setBounds (495, 390, 100, 25);
        textFieldRepetitions.setBounds (705, 390, 180, 25);
        labelRepetitions.setBounds (595, 390, 100, 25);
        labelWeight.setBounds (595, 420, 100, 25);
        textFieldWeight.setBounds (705, 420, 180, 25);
        labelMentions.setBounds (595, 450, 100, 25);
        textFieldMentions.setBounds (705, 450, 180, 25);
        buttonAddSet.setBounds (785, 485, 100, 25);
        comboBoxMuscleGroup.setBounds (280, 485, 155, 25);
        labelMuscleGroup.setBounds (60, 485, 220, 25);
    }
}
