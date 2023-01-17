package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Workout {
    private Integer ID_workout;
    private String name;
    private String targetMuscleGroup;

    public Workout(Integer ID_workout, String name, String targetMuscleGroup) {
        this.ID_workout = ID_workout;
        this.name = name;
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public Workout(ResultSet resultSet) throws SQLException {
        ID_workout = resultSet.getInt("ID_workout");
        name = resultSet.getString("name");
        targetMuscleGroup = resultSet.getString("targetMuscleGroup");
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

    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public void setTargetMuscleGroup(String targetMuscleGroup) {
        this.targetMuscleGroup = targetMuscleGroup;
    }
}
