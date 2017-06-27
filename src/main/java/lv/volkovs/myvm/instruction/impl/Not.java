package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;

import static lv.volkovs.myvm.program.Value15.not;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Not implements Instruction {

    private int destination;
    private int value;

    public Not(int destination, int value) {
        this.destination = destination;
        this.value = value;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int result = not(memory.constOrRegister(value));
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
