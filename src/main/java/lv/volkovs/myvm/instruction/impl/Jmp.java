package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Jmp implements InstructionExecution {

    private int jumpTo;

    public Jmp(Operand jumpTo) {
        this.jumpTo = jumpTo.toIndex();
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        return jumpTo;
    }

}
