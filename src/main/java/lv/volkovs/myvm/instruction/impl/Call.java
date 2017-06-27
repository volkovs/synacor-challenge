package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Call implements Instruction {

    private int jumpTo;

    public Call(int jumpTo) {
        this.jumpTo = jumpTo;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        memory.push(pointer + 1);
        return memory.constOrRegister(jumpTo);
    }

}
