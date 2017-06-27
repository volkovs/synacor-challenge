package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Out implements Instruction {

    private int asciiCode;

    public Out(int asciiCode) {
        this.asciiCode = asciiCode;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        System.out.print((char) memory.constOrRegister(asciiCode));
        return DO_NOT_JUMP;
    }

}
