package lv.volkovs.myvm.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
class OperandTest {

    private static final int MAX_VALUE = 32767;

    private Operand maxValue = new Operand(MAX_VALUE);

    private Operand register_0 = new Operand(MAX_VALUE + 1);

    @Test
    void isRegister() {
        assertThat(maxValue.isRegister()).isFalse();
        assertThat(register_0.isRegister()).isTrue();
    }

    @Test
    void toValue() {
        Memory memory = new Memory(Memory.EMPTY_SLOT);
        memory.setRegister(0, new Value15(10));
        memory.set(MAX_VALUE, new Value15(1));

        // constant values are NOT resolved against memory address space
        assertThat(maxValue.toValue(memory).toInt()).isEqualTo(MAX_VALUE);

        // registers are resolved against memory
        assertThat(register_0.toValue(memory).toInt()).isEqualTo(10);
    }

    @Test
    void to_string() {
        assertThat(maxValue.toString()).isEqualTo("Const 32767");
        assertThat(register_0.toString()).isEqualTo("Register 0");
    }

}