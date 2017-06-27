package lv.volkovs.myvm.instruction.impl;

import lv.volkovs.myvm.program.Memory;
import lv.volkovs.myvm.instruction.Instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * @author Mihails Volkovs mihails.volkovs@gmail.com
 *         Date: 22.06.2017
 */
public class In implements Instruction {

    private int destination;

    public In(int destination) {
        this.destination = destination;
    }

    @Override
    public int execute(Memory memory, int pointer) {
        int result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            result = parseInt(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        memory.set(destination, result);
        return DO_NOT_JUMP;
    }

}
