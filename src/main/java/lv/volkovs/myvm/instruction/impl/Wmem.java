package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Wmem implements InstructionExecution {

    private Operand destination;
    private Operand value;

    public Wmem(Operand destination, Operand value) {
        this.destination = destination;
        this.value = value;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        memory.set(destination.toValue(memory).toInt(), value.toValue(memory));
        return DO_NOT_JUMP;
    }

}
