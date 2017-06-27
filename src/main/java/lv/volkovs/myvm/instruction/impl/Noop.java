package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Noop implements Instruction {

    @Override
    public int execute(Memory memory, int pointer) {
        // do nothing
        return DO_NOT_JUMP;
    }

}
