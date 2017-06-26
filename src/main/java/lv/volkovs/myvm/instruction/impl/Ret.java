package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Ret implements InstructionExecution {

    @Override
    public int execute(InstructionExecutionContext context) {
        return context.getMemory().pop().toInt();
    }

}
