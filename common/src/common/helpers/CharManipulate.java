package common.helpers;

public class CharManipulate implements CharSequence {

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public static String ReverseString(String string) {
        String revString = "";
        for (int i = string.length()-1; i > -1; i--) {
            revString += string.charAt(i);
        }
        return revString;
    }
}
