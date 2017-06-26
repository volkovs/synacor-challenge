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
public class And implements InstructionExecution {

    private int destination;
    private Operand value1;
    private Operand value2;

    public And(Operand destination, Operand value1, Operand value2) {
        this.destination = destination.toIndex();
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        Value15 result = value1.toValue(memory).and(value2.toValue(memory));
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
