package lv.volkovs.myvm.heap;

import com.google.common.annotations.VisibleForTesting;

import java.util.Stack;

import static java.lang.String.format;
import static lv.volkovs.myvm.heap.Value15.ZERO;

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

    private Value15[] registers = new Value15[8];

    // unlimited stack
    private Stack<Value15> stack = new Stack<>();

    public Memory(int[] addressSpace) {
        this.addressSpace = addressSpace;
    }

    public Value15 constOrRegister(int operand) {

        // value in register
        if (isRegister(operand)) {
            return new Value15(get(operand));
        }

        // constant value
        return new Value15(operand);
    }

    public int get(int index) {
        if (isRegister(index)) {
            Value15 register = registers[index % MAX_VALUE - 1];
            if (register == null) {
                return 0;
            }
            return register.toInt();
        }
        return addressSpace[index];
    }

    public void set(int index, Value15 value) {
        if (isRegister(index)) {
            registers[toRegisterNumber(index)] = value;
        } else {
            addressSpace[index] = value.toInt();
        }
    }

    @VisibleForTesting
    static boolean isRegister(int index) {
        return index > MAX_VALUE;
    }

    public Value15 pop() {
        return stack.pop();
    }

    public void push(Value15 value) {
        stack.push(value);
    }

    public void setRegister(int register, Value15 value) {
        registers[register] = value;
    }

    public Value15 getRegister(int register) {
        Value15 result = registers[register];
        if (result == null) {
            return ZERO;
        }
        return result;
    }

    static String toString(int operand) {
        return isRegister(operand) ? format("Register %s", toRegisterNumber(operand)) : format("Const %s", operand);
    }

    private static int toRegisterNumber(int index) {
        return index % MAX_VALUE - 1;
    }
}
