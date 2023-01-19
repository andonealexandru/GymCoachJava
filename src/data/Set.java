package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Set {

    private Integer setId;
    private Integer exerciseId;
    private Integer weight;
    private Integer repetitions;
    private String mentions;

    @Override
    public String toString() {
        return weight + " kg, " + repetitions + "reps, " + mentions;
    }

    public Set(Integer exerciseId, String mentions, Integer weight, Integer repetitions) {
        this.exerciseId = exerciseId;
        this.weight = weight;
        this.repetitions = repetitions;
        this.mentions = mentions;
    }

    public Set(ResultSet resultSet) throws SQLException {
        setId = resultSet.getInt("set_id");
        exerciseId = resultSet.getInt("exercise_id");
        mentions = resultSet.getString("mentions");
        weight = resultSet.getInt("weight");
        repetitions = resultSet.getInt("repetitions");
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

    public static void CreateSet(Set set) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO set(exercise_id, mentions, weight, repetitions) VALUES ('"
                + set.exerciseId + "', '" + set.mentions + "', '" + set.weight + "', '" + set.repetitions + "');");
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public String getMentions() {
        return mentions;
    }

    public void setMentions(String mentions) {
        this.mentions = mentions;
    }
}
