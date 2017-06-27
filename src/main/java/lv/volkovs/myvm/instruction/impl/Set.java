package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;

import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Set implements Instruction {

    private int register;
    private int value;

    public Set(int register, int value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        memory.set(register, memory.constOrRegister(value));
        return DO_NOT_JUMP;
    }

}
