package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.heap.Value15;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Not implements InstructionExecution {

    private int destination;
    private Operand value;

    public Not(Operand destination, Operand value) {
        this.destination = destination.toIndex();
        this.value = value;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();

        Value15 result = value.toValue(memory).not();
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}