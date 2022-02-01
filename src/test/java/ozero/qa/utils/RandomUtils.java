package ozero.qa.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomString(int lenght) {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < lenght) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

    public static String getRandomPhone(String code) {
        return code + getRandomPhone();
    }

    public static String getDifficultRandomPhone(String code) {
        return code + "(" + getRandomLong(111L, 999L) + ")" + getRandomLong(111L, 999L) + "-" + getRandomLong(1111L, 9999L);
    }

    public static String getRandomEmail() {
        String emailDomain = "@ozeromail.ru";
        return "test" + getRandomString(10) + emailDomain;
    }

}
