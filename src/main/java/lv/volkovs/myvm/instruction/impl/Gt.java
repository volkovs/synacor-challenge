package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.heap.Value15;
import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Gt implements InstructionExecution {

    private int destination;
    private Operand value1;
    private Operand value2;

    public Gt(Operand destination, Operand value1, Operand value2) {
        this.destination = destination.toIndex();
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        if (value1.toValue(memory).toInt() > value2.toValue(memory).toInt()) {
            memory.set(destination, new Value15(1));
        } else {
            memory.set(destination, new Value15(0));
        }
        return DO_NOT_JUMP;
    }

}
