package lv.volkovs.myvm.instruction.impl;


import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Jf implements Instruction {

    private int zero;

    private int jumpTo;

    public Jf(int zero, int jumpTo) {
        this.zero = zero;
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        if (memory.constOrRegister(zero) == 0) {
            return jumpTo;
        }
        return DO_NOT_JUMP;
    }

}
