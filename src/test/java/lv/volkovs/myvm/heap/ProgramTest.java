package lv.volkovs.myvm.heap;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 25.06.2017
 */
@EnableRuleMigrationSupport
class ProgramTest {

    @Rule
    public final SystemOutRule out = new SystemOutRule().enableLog().muteForSuccessfulTests();

    private Program program;

    @BeforeEach
    void setUp() {
        program = new Program(new int[]{
                // Stores into register 1 constant value 61
                16, 32769, 61,
                // Stores into register 0 the sum of 4 and the value contained in register 1.
                9, 32768, 32769, 4,
                // Outputs to the terminal the character with the ascii code contained in register 0 (value = 65).
                19, 32768
        });
    }

    @Test
    void execute() {
        program.execute();
        assertThat(((int) out.getLog().charAt(0))).isEqualTo(65);
        assertThat((out.getLog().charAt(0))).isEqualTo('A');
    }

}