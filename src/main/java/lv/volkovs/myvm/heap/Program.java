package lv.volkovs.myvm.heap;

import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.InstructionExecutionContext;
import lv.volkovs.myvm.instruction.Opcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lv.volkovs.myvm.instruction.InstructionExecutionFactory.create;
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

    private Operand[] operands;

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
            int operandsCount = opcode.getOperandsCount();
            operands = new Operand[operandsCount];
            for (int i = 0; i < operands.length; i++) {
                operands[i] = new Operand(code[++pointer]);
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
            // LOG.debug(String.format("%s. Executing opcode: %s %s", pointer - operands.length, opcode, Arrays.toString(operands)));
        }
    }

    protected void executeInstruction(InstructionExecution instruction) {
        InstructionExecutionContext executionContext = new InstructionExecutionContext(memory, pointer);
        int jumpTo = instruction.execute(executionContext);
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

    Operand[] getOperands() {
        return operands;
    }
}
