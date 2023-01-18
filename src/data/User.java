package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Boolean active;

    public User(String username, String password, Boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public User(ResultSet resultSet) throws SQLException {
        user_id = resultSet.getInt("user_id");
        username = resultSet.getString("username");
        password = resultSet.getString("password");
        active = resultSet.getBoolean("active");
    }

    public static User GetByUsername(String username) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.user WHERE username = '" + username + "';");
        if (!resultSet.isBeforeFirst())
            return null;
        resultSet.next();
        return new User(resultSet);
    }

    public static boolean CreateUser(User user) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        if (GetByUsername(user.username) != null)
            return false;
        statement.executeUpdate("INSERT INTO public.user(username, password, active) VALUES ('" +
                user.username + "', '" + user.password + "', '1');");
        return true;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
