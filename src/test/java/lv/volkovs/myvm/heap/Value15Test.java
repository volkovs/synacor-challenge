package lv.volkovs.myvm.heap;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.valueOf;
import static lv.volkovs.myvm.heap.Value15.MAX_VALUE;
import static lv.volkovs.myvm.heap.Value15.add;
import static lv.volkovs.myvm.heap.Value15.and;
import static lv.volkovs.myvm.heap.Value15.mod;
import static lv.volkovs.myvm.heap.Value15.mult;
import static lv.volkovs.myvm.heap.Value15.normalize;
import static lv.volkovs.myvm.heap.Value15.not;
import static lv.volkovs.myvm.heap.Value15.or;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
class Value15Test {

    private static final int PI = normalize(314159265);

    @Test
    void test_add() {
        assertThat(add(32758, 15)).isEqualTo(5);
        assertThat(add(0, 32758 + 15)).isEqualTo(5);
    }

    @Test
    void test_mult() {
        assertThat(mult(2,0)).isEqualTo(0);
        assertThat(mult(2,1)).isEqualTo(2);
        assertThat(mult(2,2)).isEqualTo(4);
        assertThat(mult(2,4)).isEqualTo(8);

        assertThat(mult(-2, 0)).isEqualTo(0);
        assertThat(mult(-2, 1)).isEqualTo(-2);
        assertThat(mult(-2, 2)).isEqualTo(-4);
        assertThat(mult(-2, 4)).isEqualTo(-8);
    }

    @Test
    void test_mod() {
        assertThat(mod(5, 3)).isEqualTo(2);
    }

    @Test
    void test_and() {
        assertThat(and(MAX_VALUE, PI)).isEqualTo(PI);
        assertThat(and(0, PI)).isEqualTo(0);
    }

    @Test
    void test_or() {
        assertThat(or(MAX_VALUE, PI)).isEqualTo(MAX_VALUE);
        assertThat(or(0, PI)).isEqualTo(PI);
    }

    @Test
    void test_not() {
        assertThat(not(MAX_VALUE)).isEqualTo(0);
        assertThat(not(0)).isEqualTo(MAX_VALUE);

        String string = "101010101010101";
        String notStr = "010101010101010";
        Integer value = valueOf(string, 2);
        Integer notValue = valueOf(notStr, 2);

        assertThat(not(value)).isEqualTo(notValue);
        assertThat(not(notValue)).isEqualTo(value);
    }

}