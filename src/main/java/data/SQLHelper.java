package data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static util.LoggingUtils.logInfo;
import static util.TestProperties.getProperties;

public class SQLHelper {
    static String statusCreditCad = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
    static String statusPaymentCad = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
    static String numberDate = "SELECT COUNT(1) FROM order_entity";
    private SQLHelper() {
    }

    private static Statement connection() throws SQLException {
        return DriverManager.getConnection(getProperties("spring.datasource.url"), getProperties("spring.datasource.username"), getProperties("spring.datasource.password")).createStatement();
    }

    private static String connectSQL(String date) {
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

    public static int getNumSQL() {
        int number = Integer.parseInt(connectSQL(numberDate));
        logInfo("Получение из базы номера последней записи - " + number);
        return number;
    }

    public static String getStatusPaymentCad() {
        String status = connectSQL(statusPaymentCad);
        logInfo("Получение из базы оплаченных статуса последней записи - " + status);
        return status;
    }

    public static String getStatusCreditCad() {
        String status = connectSQL(statusCreditCad);
        logInfo("Получение из базы кредитных статуса последней записи - " + status);
        return status;
    }
}