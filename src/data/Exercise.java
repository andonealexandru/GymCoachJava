package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise {
    private Integer ID_exercise;
    private Integer ID_workout;
    private String name;
    private String targetMuscle;

    public Exercise(Integer ID_exercise, Integer ID_workout, String name, String targetMuscle) {
        this.ID_exercise = ID_exercise;
        this.ID_workout = ID_workout;
        this.name = name;
        this.targetMuscle = targetMuscle;
    }

    public Exercise(ResultSet resultSet) throws SQLException {
        ID_exercise = resultSet.getInt("ID_exercise");
        ID_workout = resultSet.getInt("ID_workout");
        name = resultSet.getString("name");
        targetMuscle = resultSet.getString("targetMuscle");
    }

    public Integer getID_exercise() {
        return ID_exercise;
    }

    public void setID_exercise(Integer ID_exercise) {
        this.ID_exercise = ID_exercise;
    }

    public Integer getID_workout() {
        return ID_workout;
    }

    public void setID_workout(Integer ID_workout) {
        this.ID_workout = ID_workout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }
}
