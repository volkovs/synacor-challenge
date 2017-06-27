package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Jt implements Instruction {

    private int nonzero;

    private int jumpTo;

    public Jt(int nonzero, int jumpTo) {
        this.nonzero = nonzero;
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int value = memory.constOrRegister(nonzero);
        if (value != 0) {
            return jumpTo;
        }
        return DO_NOT_JUMP;
    }

}
