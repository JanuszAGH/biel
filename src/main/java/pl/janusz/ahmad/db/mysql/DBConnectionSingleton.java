package pl.janusz.ahmad.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
enum DBConnectionSingleton {
    INSTANCE;

    private final String url = "jdbc:mysql://localhost:3306/boystoys";
    private final String user = "vagrant";
    private final String password = "";

    private Connection connection;

    DBConnectionSingleton() {

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {

        return connection;
    }
}
