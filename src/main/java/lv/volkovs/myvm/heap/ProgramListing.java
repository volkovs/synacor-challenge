package lv.volkovs.myvm.heap;

import lv.volkovs.myvm.instruction.InstructionExecution;
import lv.volkovs.myvm.instruction.Opcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class ProgramListing extends Program {

    private List<String> listing = new ArrayList<>();

    public ProgramListing(int[] code) {
        super(code);
        execute();
    }

    @Override
    protected void executeInstruction(InstructionExecution instruction) {
        String opcode = instruction.getClass().getSimpleName();
        Operand[] operands = getOperands();
        String line = format("%n%s. %s %s", getPointer() - operands.length, opcode, Arrays.toString(operands));
        listing.add(line);
        incrementPointer();
    }

    @Override
    protected boolean handled(int opcode) {
        String message = String.format("%n%s. Unknown opcode: %s", getPointer(), opcode);
        listing.add(message);
        return true;
    }

    public List<String> getListing() {
        return listing;
    }

    protected void logExecution(Opcode opcode) {
        // do nothing
    }
}
