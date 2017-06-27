package lv.volkovs.myvm.program;

import org.junit.jupiter.api.Test;

import static lv.volkovs.myvm.program.ProgramLoader.decodeLittleEndian;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 23.06.2017
 */
class ProgramLoaderTest {

    @Test
    void decode_little_endian() {
        assertThat(decodeLittleEndian((byte) 10, (byte) 0)).isEqualTo(10);
        assertThat(decodeLittleEndian((byte) 255, (byte) 0)).isEqualTo(255);
        assertThat(decodeLittleEndian((byte) 0, (byte) 1)).isEqualTo(256);
        assertThat(decodeLittleEndian((byte) 10, (byte) 1)).isEqualTo(266);
    }

}