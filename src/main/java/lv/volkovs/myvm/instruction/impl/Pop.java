package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Pop implements Instruction {

    private int indexTo;

    public Pop(int indexTo) {
        this.indexTo = indexTo;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int valueFromStack = memory.pop();
        memory.set(indexTo, valueFromStack);
        return DO_NOT_JUMP;
    }

}
