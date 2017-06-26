package lv.volkovs.myvm.heap;

import com.google.common.annotations.VisibleForTesting;

import static java.lang.String.format;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Operand {

    private static final int MAX_VALUE = 32767;

    private int value;

    public Operand(int value) {
        this.value = value;
    }

    public Value15 toValue(Memory memory) {

        // value in register
        if (isRegister()) {
            return memory.get(value);
        }

        // constant value
        return new Value15(value);
    }

    public int toIndex() {
        return value;
    }

    @VisibleForTesting
    boolean isRegister() {
        return value > MAX_VALUE;
    }

    @Override
    public String toString() {
        return isRegister() ? format("Register %s", toRegister()) : format("Const %s", value);
    }

    private int toRegister() {
        return value - MAX_VALUE - 1;
    }
}
