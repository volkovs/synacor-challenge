package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Noop implements InstructionExecution {

    @Override
    public int execute(InstructionExecutionContext context) {
        // do nothing
        return DO_NOT_JUMP;
    }

}
