package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static class CardInfo {
        String numberCard;
        String statusCard;

        public String getNumberCard() {
            return numberCard;
        }

        public String getStatusCard() {
            return statusCard;
        }

        public CardInfo(String numberCard, String statusCard) {
            this.numberCard = numberCard;
            this.statusCard = statusCard;
        }

    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("4444 4444 4444 4441", "APPROVED");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("4444 4444 4444 4442", "DECLINED");
    }

    public static String getRandNumbCardInfo(int length) {
        String num = faker.number().digits(length);
        if (num.equals("4444444444444441") || num.equals("4444444444444442") || num.equals("0000000000000000")) {
            num = faker.number().digits(length);
        }
        return num;
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

    public static String getUserNameCardInfo() {
        return faker.name().firstName();
    }

    public static String getUserSurnameCardInfo() {
        return faker.name().lastName();
    }

    public static String getUserLongCardInfo() {
        return faker.name().nameWithMiddle();
    }

    public static String getUserCyrillicCardInfo() {
        return new Faker(new Locale("ru")).name().fullName();
    }

    public static String getCvcCodCardInfo() {
        return faker.number().digits(3);
    }

    public static String getTextCardInfo(int length) {
        return randString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", length);
    }

    public static String getSymbolCardInfo(int length) {
        return randString("\\|\"'`&<>^*«»@#№%~", length);
    }

    public static String getSingCardInfo(int length) {
        return randString(",;:?.!-+=/", length);
    }

    private static String randString(String s, int length) {
        String t = "";
        for (int i = 0; i < length; i++) {
            t += (s.charAt((int) (Math.random() * s.length())));
        }
        return t;
    }

    public static String getCheckGoodInfo() {
        return "Успешно\n" + "Операция одобрена Банком.";
    }

    public static String getCheckErrorInfo() {
        return "Ошибка!\n" + "Банк отказал в проведении операции.";
    }

    public static String getCheckNoValidInfo() {
        return "Неверный формат";
    }

    public static String getCheckWrongInfo() {
        return "Неверно указан срок действия карты";
    }

    public static String getCheckExpiredInfo() {
        return "Истёк срок действия карты";
    }

    public static String getCheckRequiredInfo() {
        return "Поле обязательно для заполнения";
    }
}