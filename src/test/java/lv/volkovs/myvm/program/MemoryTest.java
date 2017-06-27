package lv.volkovs.myvm.program;

import org.junit.jupiter.api.Test;

import static lv.volkovs.myvm.program.Memory.EMPTY_SLOT;
import static lv.volkovs.myvm.program.Memory.MAX_VALUE;
import static lv.volkovs.myvm.program.Memory.REGISTER_0;
import static lv.volkovs.myvm.program.Memory.REGISTER_7;
import static lv.volkovs.myvm.program.Memory.isRegister;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
class MemoryTest {

    private static final int MAX_ADDRESS = 32775;

    private Memory memory = new Memory(EMPTY_SLOT);

    @Test
    void registers_limit() {
        assertThat(Memory.ADDRESS_SPACE_UPPER_LIMIT).isEqualTo(32775);
    }

    @Test
    void get() {
        assertThat(memory.get(MAX_ADDRESS)).isEqualTo(0);

        try {
            memory.get(MAX_ADDRESS + 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // OK
        }
    }

    @Test
    void setRegister() {
        memory.setRegister(0, 10);
        assertThat(memory.get(MAX_VALUE + 1)).isEqualTo(10);
    }

    @Test
    void is_register() {
        assertThat(isRegister(MAX_VALUE)).isFalse();
        assertThat(isRegister(REGISTER_0)).isTrue();
    }

    @Test
    void set() {
        memory.set(REGISTER_0, MAX_VALUE);
        assertThat(memory.getRegister(0)).isEqualTo(MAX_VALUE);
        assertThat(memory.get(REGISTER_0)).isEqualTo(MAX_VALUE);

        memory.set(REGISTER_7, 10);
        assertThat(memory.getRegister(7)).isEqualTo(10);
        assertThat(memory.get(REGISTER_0)).isEqualTo(MAX_VALUE);
    }

    @Test
    void toValue() {
        Memory memory = new Memory(Memory.EMPTY_SLOT);
        memory.setRegister(0, 10);
        memory.set(MAX_VALUE, 1);

        // constant values are NOT resolved against memory address space
        assertThat(memory.constOrRegister(MAX_VALUE)).isEqualTo(MAX_VALUE);

        // registers are resolved against memory
        assertThat(memory.constOrRegister(REGISTER_0)).isEqualTo(10);
    }

    @Test
    void to_string() {
        assertThat(Memory.toString(MAX_VALUE)).isEqualTo("Const 32767");
        assertThat(Memory.toString(REGISTER_0)).isEqualTo("Register 0");
    }

}