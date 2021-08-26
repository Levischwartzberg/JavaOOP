package common.helpers;

public class MathHelper {
    public static double e = 2.7182818284;
    public static double pi = 3.14159265359;

    public static int Factorial(int myInt) {
        int result = myInt;
        if (myInt == 1) {
            result = 1;
        }
        else {
            for (int i = myInt; i > 1; i--) {
                result = result * (i-1);
            }
        }
        return result;
    }

    public static int Exponentiate(int base, int power) {
        int result = base;
        for (int i = 0; i < power - 1; i++) {
            result = result * base;
        }
        return result;
    }

    public static double CircleArea(double radius) {
        return pi * radius * radius;
    }

}
