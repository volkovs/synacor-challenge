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
public class Jt implements InstructionExecution {

    private Operand nonzero;

    private int jumpTo;

    public Jt(Operand nonzero, Operand jumpTo) {
        this.nonzero = nonzero;
        this.jumpTo = jumpTo.toIndex();
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        Value15 value15 = nonzero.toValue(memory);
        if (value15.toInt() != 0) {
            return jumpTo;
        }
        return DO_NOT_JUMP;
    }

}
