package pl.janusz.ahmad.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class DatabaseConnectionManager {

    public Connection getConnection() {

        return Singleton.INSTANCE.getConnection();
    }

    private enum Singleton {
        INSTANCE;

        private final String url = "jdbc:mysql://localhost:3306/boystoys";
        private final String user = "vagrant";
        private final String password = "";

        private Connection connection;

        private Singleton() {

            try {
                this.connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {

            return connection;
        }
    }
}
