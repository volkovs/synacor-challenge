package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;

import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Push implements Instruction {

    private int value;

    public Push(int value) {
        this.value = value;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        memory.push(memory.constOrRegister(value));
        return DO_NOT_JUMP;
    }

}
