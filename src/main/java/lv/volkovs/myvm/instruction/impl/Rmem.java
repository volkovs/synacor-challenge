package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Rmem implements Instruction {

    private int destination;
    private int source;

    public Rmem(int destination, int source) {
        this.destination = destination;
        this.source = source;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int result = memory.get(memory.constOrRegister(source));
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
