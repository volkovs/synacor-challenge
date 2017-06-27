package lv.volkovs.myvm.instruction;

import lv.volkovs.myvm.program.Memory;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public interface Instruction {

    int DO_NOT_JUMP = -1;

    int execute(Memory memory, int pointer);

}
