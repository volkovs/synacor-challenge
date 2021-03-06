package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Eq implements Instruction {

    private int destination;
    private int value1;
    private int value2;

    public Eq(int destination, int value1, int value2) {
        this.destination = destination;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        if (memory.constOrRegister(value1) == memory.constOrRegister(value2)) {
            memory.set(destination, 1);
        } else {
            memory.set(destination, 0);
        }
        return DO_NOT_JUMP;
    }

}
