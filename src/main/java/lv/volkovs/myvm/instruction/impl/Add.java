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
public class Add implements InstructionExecution {

    private int destination;
    private Operand operand1;
    private Operand operand2;

    public Add(Operand destination, Operand operand1, Operand operand2) {
        this.destination = destination.toIndex();
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public int execute(InstructionExecutionContext context) {
        Memory memory = context.getMemory();
        Value15 value1 = operand1.toValue(memory);
        Value15 value2 = operand2.toValue(memory);

        Value15 result = value1.add(value2);
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}