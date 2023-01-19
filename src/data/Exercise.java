package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Exercise {
    private Integer exerciseId;
    private Integer workoutId;
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public Exercise(Integer workoutId, String name) {
        this.workoutId = workoutId;
        this.name = name;
    }

    public Exercise(ResultSet resultSet) throws SQLException {
        exerciseId = resultSet.getInt("exercise_id");
        workoutId = resultSet.getInt("workout_id");
        name = resultSet.getString("name");
    }

    public static Vector<Exercise> GetExercisesByWorkoutId(Integer workoutId) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.exercise WHERE workout_id =" + workoutId + ";");
        Vector<Exercise> exercises = new Vector<>();
        while(resultSet.next())
        {
            exercises.add(new Exercise((resultSet)));
        }
        return exercises;
    }

    public static void CreateExercise(Exercise exercise) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.exercise(workout_id, name) VALUES ('"
                + exercise.workoutId + "', '" + exercise.name + "');");
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer ID_exercise) {
        this.exerciseId = ID_exercise;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
