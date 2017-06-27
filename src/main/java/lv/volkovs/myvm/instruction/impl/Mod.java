package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;

import lv.volkovs.myvm.heap.Value15;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Mod implements Instruction {

    private int destination;
    private int value1;
    private int value2;

    public Mod(int destination, int value1, int value2) {
        this.destination = destination;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        Value15 result = memory.constOrRegister(value1).mod(memory.constOrRegister(value2));
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
