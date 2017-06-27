package lv.volkovs.myvm.heap;

import lv.volkovs.myvm.instruction.Instruction;
import lv.volkovs.myvm.instruction.Opcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static lv.volkovs.myvm.instruction.InstructionFactory.create;
import static lv.volkovs.myvm.instruction.Opcode.valueOf;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class Program {

    private static final Logger LOG = LoggerFactory.getLogger(Program.class);

    private Memory memory;

    private int[] code;

    private int pointer = 0;

    private Integer[] operands;

    public Program(int[] code) {
        this.code = code;
        this.memory = new Memory(code);
    }

    public void execute() {
        while (pointer < code.length) {

            Opcode opcode;
            try {
                opcode = valueOf(code[pointer]);
            } catch (UnsupportedOperationException e) {
                if (handled(code[pointer])) {
                    pointer++;
                    continue;
                } else {
                    throw e;
                }
            }

            // additionally reading operation arguments
            int operandsCount = opcode.getintsCount();
            operands = new Integer[operandsCount];
            for (int i = 0; i < operands.length; i++) {
                operands[i] = code[++pointer];
            }
            logExecution(opcode);

            executeInstruction(create(opcode, operands));
        }

        LOG.debug("Program completed");
    }

    protected boolean handled(int opcode) {
        return false;
    }

    protected void logExecution(Opcode opcode) {
        if (!"OUT".equals(opcode.name())) {
//            List<String> operandRepresentations = toString(getOperands());
//            LOG.debug(String.format("%s. Executing opcode: %s %s", pointer - operands.length, opcode, operandRepresentations));
        }
    }

    protected void executeInstruction(Instruction instruction) {
        int jumpTo = instruction.execute(memory, pointer);
        if (jumpTo > 0) {
            pointer = jumpTo;
        } else {
            pointer++;
        }
    }

    int getPointer() {
        return pointer;
    }

    void incrementPointer() {
        pointer++;
    }

    Integer[] getOperands() {
        return operands;
    }

    protected List<String> toString(Integer[] operands) {
        List<String> operandRepresentations = new ArrayList<>();
        for (Integer operand : operands) {
            operandRepresentations.add(Memory.toString(operand));
        }
        return operandRepresentations;
    }
}
