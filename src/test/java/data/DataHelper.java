package data;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    static Faker faker = new Faker(new Locale("en"));


    private DataHelper() {
    }

    public static String getFirstCardInfo() {
        return "4444 4444 4444 4441";
    }

    public static String getSecondCardInfo() {
        return "4444 4444 4444 4442";
    }

    public static String getThirdCardInfo() {
        return faker.number().digits(16);
    }

    public static String getMonthsCardInfo(int monthPlus) {
        return LocalDate.now().plusMonths(monthPlus).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYearCardInfo(int yearPlus) {
        return LocalDate.now().plusYears(yearPlus).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getUserCardInfo() {
        return faker.name().fullName();
    }

    public static String getCvcCodCardInfo() {
        return faker.number().digits(3);
    }

    public static String getTextCardInfo(int length) {
        return randString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",length);
    }
    public static String getSymbolCardInfo(int length) {
        return randString("\\|\"'`&<>^*«»@#№%~",length);
    }
    public static String getSingCardInfo(int length) {
        return randString(",;:?.!-+=/",length);
    }
    private static String randString(String s, int length) {
        String t = "";
        for (int i=0;i<length;i++) {
            t= t + s.charAt((int) (Math.random()*s.length()));
        }
        return t;
    }
}