package lv.volkovs.myvm.heap;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 21.06.2017
 */
public abstract class Value15 {

    private static final int BITNESS = 15;

    private static final int SIZE = Double.valueOf(Math.pow(2, BITNESS)).intValue();

    static final int MAX_VALUE = SIZE - 1;

    private Value15() {
        // helper class
    }

    public static int add(int value1, int value2) {
        return normalize(normalize(value1) + normalize(value2));
    }

    public static int mult(int value1, int value2) {
        return normalize(normalize(value1) * normalize(value2));
    }

    public static int mod(int value1, int value2) {
        return normalize(normalize(value1) % normalize(value2));
    }

    public static int and(int value1, int value2) {
        return normalize(normalize(value1) & normalize(value2));
    }

    public static int or(int value1, int value2) {
        return normalize(normalize(value1) | normalize(value2));
    }

    public static int not(int value) {
        int shift = 4 * 8 - BITNESS;
        int result = (~normalize(value) << shift) >>> shift;
        return normalize(result);
    }

    static int normalize(int value) {
        return value % SIZE;
    }

}
