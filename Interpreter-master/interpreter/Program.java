package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> Labels;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }


    public void addByte(ByteCode Byte) {

        this.program.add(Byte);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        Labels = new HashMap<String, Integer>();
        int testv = 0;

        for (int i = 0; i < program.program.size() + testv; i++) {
            if (program.program.get(i) instanceof LabelCode) {
                Labels.put(program.program.get(i).getData().get(0), i);
            }
        }

        for (int j = 0; j < program.program.size() + testv; j++) {
            if (program.program.get(j) instanceof FalseBranchCode || program.program.get(j) instanceof GotoCode || program.program.get(j) instanceof FalseBranchCode || program.program.get(j) instanceof CallCode){
                program.program.get(j).load(Integer.toString(Labels.get(program.program.get(j).getData().get(0))));
            }
        }
    }
}
