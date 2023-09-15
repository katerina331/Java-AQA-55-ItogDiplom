package data;

import io.qameta.allure.Step;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static util.TestProperties.getProperties;

public class SQLHelper {
    static String statusCreditCad = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
    static String statusPaymentCad = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
    static String numberDate = "SELECT COUNT(1) FROM order_entity";
    static String sqlUrl = java.lang.System.getProperties().getProperty("sqlUrl");

    private SQLHelper() {
    }

    private static Statement connection() throws SQLException {
        return DriverManager.getConnection(sqlUrl, getProperties("spring.datasource.username"), getProperties("spring.datasource.password")).createStatement();
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

    @Step("Получение из базы номера последней записи")
    public static int getNumSQL() {
        return Integer.parseInt(connectSQL(numberDate));
    }

    @Step("Получение из базы оплаченных статуса последней записи")
    public static String getStatusPaymentCad() {
        return connectSQL(statusPaymentCad);
    }

    @Step("Получение из базы кредитных статуса последней записи")
    public static String getStatusCreditCad() {
        return connectSQL(statusCreditCad);
    }
}