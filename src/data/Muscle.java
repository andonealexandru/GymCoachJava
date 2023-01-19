package data;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Muscle {

    private Integer muscleId;

    private String name;
    @Override
    public String toString() {
        return name;
    }

    public Muscle(Integer muscleId, String name) {
        this.muscleId = muscleId;
        this.name = name;
    }

    public Muscle(ResultSet resultSet) throws SQLException {
        muscleId = resultSet.getInt("muscle_id");
        name = resultSet.getString("name");
    }

    public static Vector<Set> GetSetsByExerciseId(Integer exerciseId) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.set WHERE exercise_id =" + exerciseId + ";");
        Vector<Set> sets = new Vector<>();
        while(resultSet.next())
        {
            sets.add(new Set(resultSet));
        }
        return sets;
    }

    public static Vector<Muscle> GetMuscles() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.muscle;");
        Vector<Muscle> muscles = new Vector<>();
        while(resultSet.next())
        {
            muscles.add(new Muscle(resultSet));
        }
        return muscles;
    }

    public static Muscle GetMuscleById(int id) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.muscle WHERE muscle_id = " + id + ";");
        resultSet.next();
        return new Muscle(resultSet);
    }


    public Integer getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Integer muscleId) {
        this.muscleId = muscleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
