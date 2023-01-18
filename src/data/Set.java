package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Set {

    private Integer setId;
    private Integer exerciseId;
    private String name;
    private String mentions;

    @Override
    public String toString() {
        return name;
    }

    public Set(Integer setId, Integer exerciseId, String name, String mentions) {
        this.setId = setId;
        this.exerciseId = exerciseId;
        this.name = name;
        this.mentions = mentions;
    }

    public Set(ResultSet resultSet) throws SQLException {
        setId = resultSet.getInt("set_id");
        exerciseId = resultSet.getInt("exercise_id");
        name = resultSet.getString("name");
        mentions = resultSet.getString("mentions");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMentions() {
        return mentions;
    }

    public void setMentions(String mentions) {
        this.mentions = mentions;
    }
}
