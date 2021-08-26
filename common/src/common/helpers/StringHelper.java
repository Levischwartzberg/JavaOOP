package common.helpers;

public class StringHelper {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static int countLetters(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            count++;
        }
        return count;
    }

    public static String ifAvailable(String string) {
        if (isNullOrEmpty(string)) {
            return "Value Unavailable";
        }
        else {
            return string;
        }
    }
}
