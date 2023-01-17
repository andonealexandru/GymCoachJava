package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Series {
    private Integer ID_series;
    private Integer ID_exercise;
    private String repetitionNumber;
    private Integer weight;

    public Series(Integer ID_series, Integer ID_exercise, String repetitionNumber, Integer weight) {
        this.ID_series = ID_series;
        this.ID_exercise = ID_exercise;
        this.repetitionNumber = repetitionNumber;
        this.weight = weight;
    }

    public Series(ResultSet resultSet) throws SQLException {
        ID_series = resultSet.getInt("ID_series");
        ID_exercise = resultSet.getInt("ID_exercise");
        repetitionNumber = resultSet.getString("repetitionNumber");
        weight = resultSet.getInt("weight");
    }

    public Integer getID_series() {
        return ID_series;
    }

    public void setID_series(Integer ID_series) {
        this.ID_series = ID_series;
    }

    public Integer getID_exercise() {
        return ID_exercise;
    }

    public void setID_exercise(Integer ID_exercise) {
        this.ID_exercise = ID_exercise;
    }

    public String getRepetitionNumber() {
        return repetitionNumber;
    }

    public void setRepetitionNumber(String repetitionNumber) {
        this.repetitionNumber = repetitionNumber;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
