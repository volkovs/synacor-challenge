package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Halt implements Instruction {

    @Override
    public int execute(Memory memory, int pointer) {
        System.exit(0);
        return DO_NOT_JUMP;
    }

}
