package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Jf implements InstructionExecution {

    private Operand zero;

    private int jumpTo;

    public Jf(Operand zero, Operand jumpTo) {
        this.zero = zero;
        this.jumpTo = jumpTo.toIndex();
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        if (zero.toValue(context.getMemory()).toInt() == 0) {
            return jumpTo;
        }
        return DO_NOT_JUMP;
    }

}
