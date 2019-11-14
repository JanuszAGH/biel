package pl.janusz.ahmad.db.mysql;

import java.sql.*;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class BoysMySQL {

    public static void main(String[] args) {

        final Connection connection = DBConnectionSingleton.INSTANCE.getConnection();
        final String sql = "select * from boys where id>?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 3);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.printf("%d %s %d%n",
                            resultSet.getInt("id"), resultSet.getString("boy"), resultSet.getInt("toy_id"));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
