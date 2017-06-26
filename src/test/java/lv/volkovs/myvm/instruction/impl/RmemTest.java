package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.heap.Value15;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lv.volkovs.myvm.heap.Memory.REGISTER_0;
import static lv.volkovs.myvm.heap.Memory.REGISTER_2;
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
        memory.setRegister(2, new Value15(10));
        memory.set(10, new Value15(15));

        // instruction execution instance
        Operand source = new Operand(REGISTER_2);
        Operand target = new Operand(REGISTER_0);
        Rmem rmem = new Rmem(target, source);

        // execution
        rmem.execute(new InstructionExecutionContext(memory, 0));

        // assertion
        assertThat(memory.getRegister(0).toInt()).isEqualTo(15);
    }

}