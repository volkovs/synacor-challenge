package lv.volkovs.myvm.instruction;

import lv.volkovs.myvm.heap.Memory;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class InstructionExecutionContext {

    private final Memory memory;

    private final int pointer;

    public InstructionExecutionContext(Memory memory, int pointer) {
        this.memory = memory;
        this.pointer = pointer;
    }

    public Memory getMemory() {
        return memory;
    }

    public int getPointer() {
        return pointer;
    }
}
