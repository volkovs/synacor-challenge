package lv.volkovs.myvm.instruction;

import lv.volkovs.myvm.heap.Operand;
import lv.volkovs.myvm.instruction.impl.Out;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
@EnableRuleMigrationSupport
class OutTest {

    @Rule
    public final SystemOutRule out = new SystemOutRule().enableLog();

    @Test
    void executeInternal() {
        new Out(new Operand(65)).execute(new InstructionExecutionContext(null, 0));
        assertThat(out.getLog()).isEqualTo("A");
    }

}