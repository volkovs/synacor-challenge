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
public class Call implements InstructionExecution {

    private Operand jumpTo;

    public Call(Operand jumpTo) {
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        int pointer = context.getPointer();
        Memory memory = context.getMemory();
        memory.push(new Value15(pointer + 1));
        return jumpTo.toValue(memory).toInt();
    }

}
