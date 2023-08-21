package data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLHelper {
    static String dateCad = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
    static String numberDate = "SELECT COUNT(1) FROM order_entity";
    private MySQLHelper() {

    }

    private static Statement connection() throws SQLException {
        var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        return connection.createStatement();
    }

    private static String connectMySQL(String date) {
        String result= null;
        try {
            Statement connect = connection();
            var resultSet = connect.executeQuery(date);
            if (resultSet.next()) {
                result = resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int checkNumMySQL() {
        return Integer.parseInt(connectMySQL(numberDate));
    }
    public static String checkInfoCad() {
        return connectMySQL(dateCad);
    }
}
