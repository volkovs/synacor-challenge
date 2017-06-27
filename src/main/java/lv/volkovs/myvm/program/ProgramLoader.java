package lv.volkovs.myvm.program;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class ProgramLoader {

    private static final Logger LOG = LoggerFactory.getLogger(ProgramLoader.class);

    public Program load(File binaryFile) {

        byte[] bytes;
        try {
            bytes = Files.readAllBytes(binaryFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOG.debug("File read ({} bytes).", bytes.length);
        int[] code = decodeLittleEndian(bytes);
        LOG.debug("Program read ({} double-bytes).", code.length);

        // printing program text (before its execution)
        ProgramListing programListing = new ProgramListing(code);
        LOG.debug("Program: \n" + programListing.getListing());

        return new Program(code);
    }

    private int[] decodeLittleEndian(byte[] bytes) {
        int[] decoded = new int[bytes.length / 2];
        for (int i = 0; i < bytes.length; i += 2) {
            decoded[i / 2] = decodeLittleEndian(bytes[i], bytes[i + 1]);
        }
        return decoded;
    }

    @VisibleForTesting
    static int decodeLittleEndian(byte byte1, byte byte2) {
        return (byte1 & 0xFF) | (byte2 & 0xFF) << 8;
    }

}
