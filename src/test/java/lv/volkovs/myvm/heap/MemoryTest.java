package lv.volkovs.myvm.heap;

import org.junit.jupiter.api.Test;

import static lv.volkovs.myvm.heap.Memory.EMPTY_SLOT;
import static lv.volkovs.myvm.heap.Memory.MAX_VALUE;
import static lv.volkovs.myvm.heap.Memory.REGISTER_0;
import static lv.volkovs.myvm.heap.Memory.REGISTER_7;
import static lv.volkovs.myvm.heap.Value15.ZERO;
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
        assertThat(memory.get(MAX_ADDRESS)).isEqualTo(ZERO);

        try {
            memory.get(MAX_ADDRESS + 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // OK
        }
    }

    @Test
    void setRegister() {
        memory.setRegister(0, new Value15(10));
        assertThat(memory.get(MAX_VALUE + 1).toInt()).isEqualTo(10);
    }

    @Test
    void isRegister() {
        assertThat(memory.isRegister(MAX_VALUE)).isEqualTo(false);
        assertThat(memory.isRegister(MAX_VALUE + 1)).isEqualTo(true);
        assertThat(memory.isRegister(MAX_VALUE + 8)).isEqualTo(true);
    }

    @Test
    void set() {
        memory.set(REGISTER_0, Value15.MAX_VALUE);
        assertThat(memory.getRegister(0)).isEqualTo(Value15.MAX_VALUE);
        assertThat(memory.get(REGISTER_0)).isEqualTo(Value15.MAX_VALUE);

        memory.set(REGISTER_7, new Value15(10));
        assertThat(memory.getRegister(7).toInt()).isEqualTo(10);
        assertThat(memory.get(REGISTER_0)).isEqualTo(Value15.MAX_VALUE);
    }

}