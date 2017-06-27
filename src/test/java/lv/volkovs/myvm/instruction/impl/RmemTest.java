package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lv.volkovs.myvm.program.Memory.REGISTER_0;
import static lv.volkovs.myvm.program.Memory.REGISTER_2;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 26.06.2017
 */
class RmemTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void copy_register() {

        // preparing content
        Memory memory = new Memory(Memory.EMPTY_SLOT);
        memory.setRegister(2, 10);
        memory.set(10, 15);

        // instruction execution instance
        Rmem rmem = new Rmem(REGISTER_0, REGISTER_2);

        // execution
        rmem.execute(memory, 0);

        // assertion
        assertThat(memory.getRegister(0)).isEqualTo(15);
    }

}