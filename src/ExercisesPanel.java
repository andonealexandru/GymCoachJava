import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercisesPanel extends JPanel {
    private JLabel labelTitle;
    private JButton buttonBack;
    private JList listExercises;
    private JLabel labelWorkout;
    private JLabel labelWorkoutName;
    private JLabel labelAddExercise;
    private JPasswordField textFieldAddExercise;
    private JButton buttonAddExercise;
    private JLabel labelExercise;
    private JLabel labelExerciseName;
    private JList listSet;
    private JLabel labelAddSet;
    private JTextField textFieldRepetitions;
    private JLabel labelRepetitions;
    private JLabel labelWeight;
    private JPasswordField textFieldWeight;
    private JLabel labelMentions;
    private JTextField textFieldMentions;
    private JButton buttonAddSet;
    private JComboBox comboBoxMuscleGroup;
    private JLabel labelMuscleGroup;

    public ExercisesPanel() {
        //construct preComponents
        String[] listExercisesItems = {"Item 1", "Item 2", "Item 3"};
        String[] listSetItems = {"Item 1", "Item 2", "Item 3"};
        String[] comboBoxMuscleGroupItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        labelTitle = new JLabel ("GymCoach");
        buttonBack = new JButton ("Inapoi");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeCurrentPanel(new WorkoutsPanel());
            }
        });
        listExercises = new JList (listExercisesItems);
        labelWorkout = new JLabel ("Antrenament");
        labelWorkoutName = new JLabel ("antrenamentulMeu");
        labelAddExercise = new JLabel ("Adauga un exercitiu");
        textFieldAddExercise = new JPasswordField (5);
        buttonAddExercise = new JButton ("Adauga");
        labelExercise = new JLabel ("Exercitiu");
        labelExerciseName = new JLabel ("exercitiul meu");
        listSet = new JList (listSetItems);
        labelAddSet = new JLabel ("Adauga un set");
        textFieldRepetitions = new JTextField (5);
        labelRepetitions = new JLabel ("Numar repetari:");
        labelWeight = new JLabel ("Greutate:");
        textFieldWeight = new JPasswordField (5);
        labelMentions = new JLabel ("Mentiuni:");
        textFieldMentions = new JTextField (5);
        buttonAddSet = new JButton ("Adauga");
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
        add (listSet);
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
        listSet.setBounds (495, 160, 390, 215);
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
