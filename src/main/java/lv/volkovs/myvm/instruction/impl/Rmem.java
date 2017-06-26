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
public class Rmem implements InstructionExecution {

    private Operand destination;
    private Operand source;

    public Rmem(Operand destination, Operand source) {
        this.destination = destination;
        this.source = source;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        Value15 result = memory.get(source.toValue(memory).toInt());
        memory.set(destination.toIndex(), result);
        return DO_NOT_JUMP;
    }

}
