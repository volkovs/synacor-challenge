package lv.volkovs.myvm.instruction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 24.06.2017
 */
public class InstructionFactory {

    public static Instruction create(Opcode opcode, Integer[] operands) {
        Class<? extends Instruction> executionClass = opcode.getExecutionClass();
        try {
            Constructor<? extends Instruction> constructor = (Constructor<? extends Instruction>) executionClass.getConstructors()[0];
            return constructor.newInstance(operands);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            throw new RuntimeException("Unable to instantiate instruction " + executionClass, e);
        }
    }

}
