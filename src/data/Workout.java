package data;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Workout {
    private Integer workoutId;
    private String name;
    private String muscleId;

    private Integer userId;

    public Workout(Integer workoutId, String name, String targetMuscleGroup, Integer userId) {
        this.workoutId = workoutId;
        this.name = name;
        this.muscleId = targetMuscleGroup;
        this.userId = userId;
    }

    public Workout(ResultSet resultSet) throws SQLException {
        workoutId = resultSet.getInt("workout_id");
        name = resultSet.getString("name");
        muscleId = resultSet.getString("muscle_id");
        userId = resultSet.getInt("user_id");
    }
    public static Vector<String> GetWorkoutsByUserId(Integer userId) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.workout WHERE userId =" + userId + ";");
        Vector<String> workouts = new Vector<>();
        while(resultSet.next())
        {
            workouts.add(resultSet.getString("name"));
        }
        return workouts;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer ID_workout) {
        this.workoutId = ID_workout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(String targetMuscleGroup) {
        this.muscleId = targetMuscleGroup;
    }
}
