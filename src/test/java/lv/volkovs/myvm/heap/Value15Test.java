package lv.volkovs.myvm.heap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.valueOf;
import static lv.volkovs.myvm.heap.Value15.MAX_VALUE;
import static lv.volkovs.myvm.heap.Value15.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
class Value15Test {

    private static final Value15 PI = new Value15(314159265);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void constructor() {
        assertThat(MAX_VALUE.add(1)).isEqualTo(ZERO);
        assertThat(MAX_VALUE.add(2).toInt()).isEqualTo(1);
        assertThat(MAX_VALUE.toInt()).isEqualTo(32767);
    }

    @Test
    void add() {
        assertThat(new Value15(32758).add(15).toInt()).isEqualTo(5);
        assertThat(new Value15(32758).add(new Value15(15)).toInt()).isEqualTo(5);

        assertThat(ZERO.add(32758 + 15).toInt()).isEqualTo(5);
        assertThat(ZERO.add(new Value15(32758 + 15)).toInt()).isEqualTo(5);
    }

    @Test
    void mult() {
        assertThat(ZERO.add(2).mult(0)).isEqualTo(ZERO);
        assertThat(ZERO.add(2).mult(1).toInt()).isEqualTo(2);
        assertThat(ZERO.add(2).mult(2).toInt()).isEqualTo(4);
        assertThat(ZERO.add(2).mult(4).toInt()).isEqualTo(8);

        assertThat(ZERO.add(-2).mult(0)).isEqualTo(ZERO);
        assertThat(ZERO.add(-2).mult(1)).isEqualTo(ZERO.add(-2));
        assertThat(ZERO.add(-2).mult(2)).isEqualTo(ZERO.add(-4));
        assertThat(ZERO.add(-2).mult(4)).isEqualTo(ZERO.add(-8));
    }

    @Test
    void mod() {
        assertThat(new Value15(5).mod(3).toInt()).isEqualTo(2);
    }

    @Test
    void and() {
        assertThat(MAX_VALUE.and(PI)).isEqualTo(PI);
        assertThat(ZERO.and(PI)).isEqualTo(ZERO);
    }

    @Test
    void or() {
        assertThat(MAX_VALUE.or(PI)).isEqualTo(MAX_VALUE);
        assertThat(ZERO.or(PI)).isEqualTo(PI);
    }

    @Test
    void not() {

        assertThat(MAX_VALUE.not()).isEqualTo(ZERO);
        assertThat(ZERO.not()).isEqualTo(MAX_VALUE);

        String string = "101010101010101";
        String notStr = "010101010101010";
        Integer value = valueOf(string, 2);
        Integer notValue = valueOf(notStr, 2);

        assertThat(new Value15(value).toInt()).isEqualTo(value);
        assertThat(new Value15(notValue).toInt()).isEqualTo(notValue);

        assertThat(new Value15(value).not()).isEqualTo(new Value15(notValue));
        assertThat(new Value15(notValue).not()).isEqualTo(new Value15(value));
    }

}