package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.heap.Memory;
import lv.volkovs.myvm.heap.Value15;
import lv.volkovs.myvm.instruction.Instruction;


/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class Add implements Instruction {

    private int destination;
    private int operand1;
    private int operand2;

    public Add(int destination, int operand1, int operand2) {
        this.destination = destination;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        Value15 value1 = memory.constOrRegister(operand1);
        Value15 value2 = memory.constOrRegister(operand2);
        Value15 result = value1.add(value2);
        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}