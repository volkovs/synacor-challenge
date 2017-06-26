package lv.volkovs.myvm.instruction;

import lv.volkovs.myvm.instruction.impl.Add;
import lv.volkovs.myvm.instruction.impl.And;
import lv.volkovs.myvm.instruction.impl.Call;
import lv.volkovs.myvm.instruction.impl.Eq;
import lv.volkovs.myvm.instruction.impl.Gt;
import lv.volkovs.myvm.instruction.impl.Halt;
import lv.volkovs.myvm.instruction.impl.In;
import lv.volkovs.myvm.instruction.impl.Jf;
import lv.volkovs.myvm.instruction.impl.Jmp;
import lv.volkovs.myvm.instruction.impl.Jt;
import lv.volkovs.myvm.instruction.impl.Mod;
import lv.volkovs.myvm.instruction.impl.Mult;
import lv.volkovs.myvm.instruction.impl.Noop;
import lv.volkovs.myvm.instruction.impl.Not;
import lv.volkovs.myvm.instruction.impl.Or;
import lv.volkovs.myvm.instruction.impl.Out;
import lv.volkovs.myvm.instruction.impl.Pop;
import lv.volkovs.myvm.instruction.impl.Push;
import lv.volkovs.myvm.instruction.impl.Ret;
import lv.volkovs.myvm.instruction.impl.Rmem;
import lv.volkovs.myvm.instruction.impl.Set;
import lv.volkovs.myvm.instruction.impl.Wmem;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 24.06.2017
 */
public enum Opcode {
    HALT(0, Halt.class),
    SET(1, 2, Set.class),
    PUSH(2, 1, Push.class),
    POP(3, 1, Pop.class),
    EQ(4, 3, Eq.class),
    GT(5, 3, Gt.class),
    JMP(6, 1, Jmp.class),
    JT(7, 2, Jt.class),
    JF(8, 2, Jf.class),
    ADD(9, 3, Add.class),
    MULT(10, 3, Mult.class),
    MOD(11, 3, Mod.class),
    AND(12, 3, And.class),
    OR(13, 3, Or.class),
    NOT(14, 2, Not.class),
    RMEM(15, 2, Rmem.class),
    WMEM(16, 2, Wmem.class),
    CALL(17, 1, Call.class),
    RET(18, Ret.class),
    OUT(19, 1, Out.class),
    IN(20, 1, In.class),
    NOOP(21, Noop.class);

    private int opcode;

    private int operandsCount;

    private Class<? extends InstructionExecution> executionClass;

    Opcode(int code, Class<? extends InstructionExecution> executionClass) {
        this(code, 0, executionClass);
    }

    Opcode(int code, int operandsCount, Class<? extends InstructionExecution> executionClass) {
        this.opcode = code;
        this.operandsCount = operandsCount;
        this.executionClass = executionClass;
    }

    public static Opcode valueOf(int opcode) {
        for (Opcode instruction : Opcode.values()) {
            if (instruction.opcode == opcode) {
                return instruction;
            }
        }
        throw new UnsupportedOperationException("Unsupported opcode " + opcode);
    }

    public int getOperandsCount() {
        return operandsCount;
    }

    public Class<? extends InstructionExecution> getExecutionClass() {
        return executionClass;
    }
}
