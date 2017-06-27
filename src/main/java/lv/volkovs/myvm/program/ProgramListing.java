package lv.volkovs.myvm.program;

import lv.volkovs.myvm.instruction.Instruction;
import lv.volkovs.myvm.instruction.Opcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
public class ProgramListing extends Program {

    private List<String> listing = new ArrayList<>();

    ProgramListing(int[] code) {
        super(code);
        execute();
    }

    @Override
    protected void executeInstruction(Instruction instruction) {
        String opcode = instruction.getClass().getSimpleName();
        List<String> operandRepresentations = toString(getOperands());

        String line = format("%n%s. %s %s", getPointer() - getOperands().length, opcode, operandRepresentations);
        listing.add(line);
        incrementPointer();
    }

    @Override
    protected boolean handled(int opcode) {
        String message = String.format("%n%s. Unknown opcode: %s", getPointer(), opcode);
        listing.add(message);
        return true;
    }

    List<String> getListing() {
        return listing;
    }

    protected void logExecution(Opcode opcode) {
        // do nothing
    }
}
