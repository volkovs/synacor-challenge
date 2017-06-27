package lv.volkovs.myvm;

import lv.volkovs.myvm.program.Program;
import lv.volkovs.myvm.program.ProgramLoader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        URL binary = Main.class.getClassLoader().getResource("challenge.bin");
        File binaryFile = new File(binary.toURI());
        Program program = new ProgramLoader().load(binaryFile);
        program.execute();
    }
}
