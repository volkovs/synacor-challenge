package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Out implements InstructionExecution {

    private Operand asciiCode;

    public Out(Operand asciiCode) {
        this.asciiCode = asciiCode;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        System.out.print((char)asciiCode.toValue(memory).toInt());
        return DO_NOT_JUMP;
    }

}
