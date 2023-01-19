package data;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Workout {
    private Integer workoutId;
    private String name;
    private Integer muscleId;
    @Override
    public String toString() {
        return name;
    }

    private Integer userId;

    public Workout(String name, Integer muscleId, Integer userId) {
        this.name = name;
        this.muscleId = muscleId;
        this.userId = userId;
    }

    public Workout(ResultSet resultSet) throws SQLException {
        workoutId = resultSet.getInt("workout_id");
        name = resultSet.getString("name");
        muscleId = resultSet.getInt("muscle_id");
        userId = resultSet.getInt("user_id");
    }

    public static Vector<Workout> GetWorkoutsByUserId(Integer userId) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.workout WHERE user_id =" + userId + ";");
        Vector<Workout> workouts = new Vector<>();
        while(resultSet.next())
        {
            workouts.add(new Workout(resultSet));
        }
        return workouts;
    }

    public static boolean CreateWorkout(Workout workout) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.workout(name, user_id, muscle_id) VALUES ('"
                + workout.name + "', '" + workout.userId + "', '" + workout.muscleId + "');");
        return true;
    }

    public static void UpdateMuscleForWorkout(Integer workoutId, Integer muscleId) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("UPDATE workout SET muscle_id =" + muscleId  + "WHERE workout_id = " + workoutId +";");
    }

    public static Vector<Workout> GetWorkoutsByString(int userId, String workout) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT workout.workout_id, workout.name, workout.user_id, workout.muscle_id, muscle.name FROM public.workout " +
                "INNER JOIN public.muscle ON workout.muscle_id = muscle.muscle_id\n" +
                "WHERE workout.name LIKE '%" + workout + "%' OR muscle.name LIKE '%" + workout + "%';");
        Vector<Workout> workouts = new Vector<>();
        while (resultSet.next()) {
            workouts.add(new Workout(resultSet));
        }
        return workouts;
    }

    public static Workout GetWorkoutForAnExercise(Integer workoutId_exercise) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.workout WHERE workout_id =" + workoutId_exercise + ";");
        resultSet.next();
        return new Workout((resultSet));
    }

    public Integer getUserId() {
       return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Integer muscleId) {
        this.muscleId = muscleId;
    }
}
