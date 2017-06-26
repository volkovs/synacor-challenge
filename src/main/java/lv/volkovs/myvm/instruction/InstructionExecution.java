package lv.volkovs.myvm.instruction;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public interface InstructionExecution {

    int DO_NOT_JUMP = -1;

    int execute(InstructionExecutionContext context);

}
