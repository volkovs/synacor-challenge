package lv.volkovs.myvm.instruction;

import lv.volkovs.myvm.heap.Operand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 24.06.2017
 */
public class InstructionExecutionFactory {

    public static InstructionExecution create(Opcode opcode, Operand[] operands) {
        Class<? extends InstructionExecution> executionClass = opcode.getExecutionClass();
        Constructor<?> constructor = executionClass.getConstructors()[0];

        try {
            return (InstructionExecution) constructor.newInstance((Object[])operands);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            throw new RuntimeException("Unable to instantiate instruction " + executionClass, e);
        }
    }

}
