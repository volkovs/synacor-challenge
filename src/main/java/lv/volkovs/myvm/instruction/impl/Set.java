package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Set implements InstructionExecution {

    private Operand register;
    private Operand value;

    public Set(Operand register, Operand value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        memory.set(register.toIndex(), value.toValue(memory));
        return DO_NOT_JUMP;
    }

}
