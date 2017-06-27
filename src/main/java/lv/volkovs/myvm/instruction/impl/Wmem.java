package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;

import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Wmem implements Instruction {

    private int destination;
    private int value;

    public Wmem(int destination, int value) {
        this.destination = destination;
        this.value = value;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        memory.set(memory.constOrRegister(destination), memory.constOrRegister(value));
        return DO_NOT_JUMP;
    }

}
