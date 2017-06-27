package lv.volkovs.myvm.instruction.impl;


import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Jmp implements Instruction {

    private int jumpTo;

    public Jmp(int jumpTo) {
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        return jumpTo;
    }

}
