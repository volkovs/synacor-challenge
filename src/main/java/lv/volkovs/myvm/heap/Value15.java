package lv.volkovs.myvm.heap;

import static java.lang.String.valueOf;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 21.06.2017
 */
public class Value15 {

    private static final int BITNESS = 15;

    private static final int SIZE = Double.valueOf(Math.pow(2, BITNESS)).intValue();

    static final Value15 ZERO = new Value15(0);

    static final Value15 MAX_VALUE = new Value15(SIZE - 1);

    private final int value;

    public Value15(int value) {
        this.value = value % SIZE;
    }

    public Value15 add(int that) {
        return add(new Value15(that));
    }

    public Value15 add(Value15 that) {
        return new Value15(this.value + that.value);
    }

    public Value15 mult(int that) {
        return mult(new Value15(that));
    }

    public Value15 mult(Value15 that) {
        return new Value15(this.value * that.value);
    }

    public Value15 mod(int that) {
        return mod(new Value15(that));
    }

    public Value15 mod(Value15 that) {
        return new Value15(this.value % that.value);
    }

    public Value15 and(int that) {
        return and(new Value15(that));
    }

    public Value15 and(Value15 that) {
        return new Value15(this.value & that.value);
    }

    public Value15 or(int that) {
        return or(new Value15(that));
    }

    public Value15 or(Value15 that) {
        return new Value15(this.value | that.value);
    }

    public Value15 not() {
        int shift = 4 * 8 - BITNESS;
        return new Value15((~this.value << shift) >>> shift);
    }

    public int toInt() {
        return value;
    }

    @Override
    public String toString() {
        return valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value15 value15 = (Value15) o;
        return value == value15.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
