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
public class Pop implements InstructionExecution {

    private int indexTo;

    public Pop(Operand indexTo) {
        this.indexTo = indexTo.toIndex();
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        Value15 valueFromStack = memory.pop();
        memory.set(indexTo, valueFromStack);
        return DO_NOT_JUMP;
    }

}
