package lv.volkovs.myvm.heap;

import com.google.common.annotations.VisibleForTesting;

import java.util.Stack;

import static java.lang.String.format;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Memory {

    static final int MAX_VALUE = 32767;

    public static final int REGISTER_0 = MAX_VALUE + 1;
    public static final int REGISTER_1 = MAX_VALUE + 2;
    public static final int REGISTER_2 = MAX_VALUE + 3;
    static final int REGISTER_3 = MAX_VALUE + 4;
    static final int REGISTER_4 = MAX_VALUE + 5;
    static final int REGISTER_5 = MAX_VALUE + 6;
    static final int REGISTER_6 = MAX_VALUE + 7;
    static final int REGISTER_7 = MAX_VALUE + 8;

    static final int ADDRESS_SPACE_UPPER_LIMIT = MAX_VALUE + 8;

    public static final int[] EMPTY_SLOT = new int[ADDRESS_SPACE_UPPER_LIMIT + 1];

    private final int[] addressSpace;

    private int[] registers = new int[8];

    // unlimited stack
    private Stack<Integer> stack = new Stack<>();

    public Memory(int[] addressSpace) {
        this.addressSpace = addressSpace;
    }

    public int constOrRegister(int operand) {

        // value in register
        if (isRegister(operand)) {
            return get(operand);
        }

        // constant value
        return operand;
    }

    /**
     * Gets value from memory.
     *
     * Provided argument is pointer into either memory address space
     * or into registers. In later case memory index is looked up in
     * according register.
     */
    public int get(int index) {
        if (isRegister(index)) {
            return registers[toRegisterNumber(index)];
        }
        return addressSpace[index];
    }

    public void set(int index, int value) {
        if (isRegister(index)) {
            registers[toRegisterNumber(index)] = value;
        } else {
            addressSpace[index] = value;
        }
    }

    @VisibleForTesting
    static boolean isRegister(int index) {
        return index > MAX_VALUE;
    }

    public int pop() {
        return stack.pop();
    }

    public void push(int value) {
        stack.push(value);
    }

    public void setRegister(int register, int value) {
        registers[register] = value;
    }

    public int getRegister(int register) {
        return registers[register];
    }

    static String toString(int operand) {
        return isRegister(operand) ? format("Register %s", toRegisterNumber(operand)) : format("Const %s", operand);
    }

    private static int toRegisterNumber(int index) {
        return index % MAX_VALUE - 1;
    }
}
