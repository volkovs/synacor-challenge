package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;

import static lv.volkovs.myvm.program.Value15.mult;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Mult implements Instruction {

    private int destination;
    private int value1;
    private int value2;

    public Mult(int destination, int value1, int value2) {
        this.destination = destination;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int result = mult(memory.constOrRegister(value1), memory.constOrRegister(value2));
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
